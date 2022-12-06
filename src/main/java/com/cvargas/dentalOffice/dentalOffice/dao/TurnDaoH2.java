package com.cvargas.dentalOffice.dentalOffice.dao;

import com.cvargas.dentalOffice.dentalOffice.dao.interfaces.IDaoCrud;
import com.cvargas.dentalOffice.dentalOffice.domain.Patient;
import com.cvargas.dentalOffice.dentalOffice.domain.Turn;
import com.cvargas.dentalOffice.dentalOffice.model.Dentist;
import com.cvargas.dentalOffice.dentalOffice.utils.H2DBConnection;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class TurnDaoH2 implements IDaoCrud<Turn> {

    private static final Logger logger = Logger.getLogger(String.valueOf(DentistDaoH2.class));
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public Turn create(Turn turn) {
        Patient patient = null;
        Dentist dentist = null;

        try {
            PatientDaoH2 patientDaoH2 = new PatientDaoH2();
            DentistDaoH2 dentistDaoH2 = new DentistDaoH2();

            patient = patientDaoH2.read(turn.getPatient().getId());
            dentist = dentistDaoH2.read(Integer.parseInt(turn.getDentist().getId().toString()));

            connection = H2DBConnection.getConnection();

            logger.info("Creando Turno...");
            // creamos la query de crear dentists de forma dinamica.
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO TURNS(patient_id, dentist_id, date) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setInt(1, patient.getId());
            preparedStatement.setLong(2, dentist.getId());
            preparedStatement.setDate(3, Date.valueOf(turn.getDate()));

            // ejecutamos la query
            preparedStatement.executeUpdate();

            ResultSet keys = preparedStatement.getGeneratedKeys();
            while (keys.next()) {
                turn.setId(keys.getInt(1));
            }

            preparedStatement.close();

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return turn;
    }

    @Override
    public List<Turn> readAll() {
        List<Turn> turnList = new ArrayList<>();
        try {
            PatientDaoH2 patientDaoH2 = new PatientDaoH2();
            DentistDaoH2 dentistDaoH2 = new DentistDaoH2();
            connection = H2DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM turns");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int patient_id = resultSet.getInt("patient_id");
                int dentist_id = resultSet.getInt("dentist_id");
                LocalDate date = LocalDate.parse(resultSet.getDate("date").toString());

                Patient patient = patientDaoH2.read(patient_id);
                Dentist dentist = dentistDaoH2.read(dentist_id);

                turnList.add(new Turn(id, dentist, patient, date));
            }

            preparedStatement.close();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //TODO: preguntarle al profe que es mejor usar connection.close o preparedStatement.close();
//                if (connection != null &&)
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return turnList;
    }

    @Override
    public Turn read(Integer id) {
        Turn turn = null;

        try {
            PatientDaoH2 patientDaoH2 = new PatientDaoH2();
            DentistDaoH2 dentistDaoH2 = new DentistDaoH2();
            connection = H2DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM turns WHERE id=?;");
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_turn = resultSet.getInt("id");
                int patient_id = resultSet.getInt("patient_id");
                int dentist_id = resultSet.getInt("dentist_id");
                LocalDate date = LocalDate.parse(resultSet.getDate("date").toString());

                Patient patient = patientDaoH2.read(patient_id);
                Dentist dentist = dentistDaoH2.read(dentist_id);

                turn = new Turn(id_turn, dentist, patient, date);
            }

            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                //TODO: preguntarle al profe que es mejor usar connection.close o preparedStatement.close();
//                if (connection != null &&)
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return turn;
    }

    @Override
    public Turn update(Turn turn) {
        Patient patient = null;
        Dentist dentist = null;

        try {
            PatientDaoH2 patientDaoH2 = new PatientDaoH2();
            DentistDaoH2 dentistDaoH2 = new DentistDaoH2();

            patient = patientDaoH2.read(turn.getPatient().getId());
            dentist = dentistDaoH2.read(Integer.parseInt(turn.getDentist().getId().toString()));

            connection = H2DBConnection.getConnection();

            preparedStatement = connection.prepareStatement(
                    "UPDATE turns SET dentist_id=?, patient_id=?, date=? WHERE id =?;");
            preparedStatement.setLong(1, dentist.getId());
            preparedStatement.setInt(2, patient.getId());
            preparedStatement.setDate(3, Date.valueOf(turn.getDate()));
            preparedStatement.setInt(4, turn.getId());

            // ejecutamos la query
            preparedStatement.executeUpdate();

            preparedStatement.close();

            logger.info("La información ha sido actualizado");
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return turn;
    }

    @Override
    public Turn delete(Integer id) {
        Turn turn = null;

        try {
            turn = read(id);
            PatientDaoH2 patientDaoH2 = new PatientDaoH2();
            DentistDaoH2 dentistDaoH2 = new DentistDaoH2();
            connection = H2DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM turns WHERE id=?;");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                //TODO: preguntarle al profe que es mejor usar connection.close o preparedStatement.close();
//                if (connection != null &&)
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return turn;
    }
}
