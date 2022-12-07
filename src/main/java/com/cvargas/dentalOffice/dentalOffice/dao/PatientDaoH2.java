package com.cvargas.dentalOffice.dentalOffice.dao;

import com.cvargas.dentalOffice.dentalOffice.dao.interfaces.IDaoCrud;
import com.cvargas.dentalOffice.dentalOffice.model.Address;
import com.cvargas.dentalOffice.dentalOffice.model.Patient;
import com.cvargas.dentalOffice.dentalOffice.utils.H2DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class PatientDaoH2 implements IDaoCrud<Patient> {

    private static final Logger logger = Logger.getLogger(String.valueOf(DentistDaoH2.class));

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    @Override
    public Patient create(Patient patient) {
        Address address = null;

        AddressDaoH2 addressDaoH2 = new AddressDaoH2();
        address = addressDaoH2.create(patient.getAddress());
        System.out.println(address);
        try {
            connection = H2DBConnection.getConnection();
            patient.getAddress().setId(address.getId());

            PreparedStatement preparedStatement = connection.prepareStatement(
                    //Statement.RETURN_GENERATED_KEYS => para que la consulta retorne el primary key del paciente creado
                    "INSERT INTO patients(name, last_name, email, dni, discharge_day, address_id) " +
                            "VALUES(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setString(3, patient.getEmail());
            preparedStatement.setString(4, patient.getDNI());
            preparedStatement.setDate(5, Date.valueOf(patient.getDischargeDay()));
            preparedStatement.setLong(6, patient.getAddress().getId());

            preparedStatement.executeUpdate();


            // llaves del id
            ResultSet keys= preparedStatement.getGeneratedKeys();

            while (keys.next()) {
                patient.setId(keys.getLong(1));
            }

            preparedStatement.close();

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                connection.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return patient;
    }

    @Override
    public List<Patient> readAll() {
        List<Patient> patientList = new ArrayList<>();
        Patient patient = null;
        Address address = null;

        try {
            AddressDaoH2 addressDaoH2 = new AddressDaoH2();
            connection = H2DBConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM patients");
            resultSet= preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_add = resultSet.getInt(7);
                address = addressDaoH2.read(id_add);

                patient = new Patient(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6).toLocalDate(),
                        address);

                patientList.add(patient);
            }
            preparedStatement.close();

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return patientList;
    }

    @Override
    public Patient read(Integer id) {

        Patient patient = null;
        Address address;

        try {
            AddressDaoH2 addressDaoH2 = new AddressDaoH2();
            connection =H2DBConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PATIENTS WHERE id=?;");
            preparedStatement.setInt(1, id);
            ResultSet rs= preparedStatement.executeQuery();

            while (rs.next()) {
                int id_add = rs.getInt(7);
                address = addressDaoH2.read(id_add);

                patient = new Patient(rs.getLong(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6).toLocalDate(),
                        address);
            }

            preparedStatement.close();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                connection.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return patient;
    }

    @Override
    public Patient update(Patient patient) {
        Address address = null;

        try {
            connection = H2DBConnection.getConnection();
            AddressDaoH2 addressDaoH2 = new AddressDaoH2();
            address = addressDaoH2.update(patient.getAddress());

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE patients SET name=?, last_name=?, email=?, dni=?, discharge_day=?, address_id=? WHERE id = ?"
            );
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setString(3, patient.getEmail());
            preparedStatement.setString(4, patient.getDNI());
            preparedStatement.setDate(5, Date.valueOf(patient.getDischargeDay()));
            preparedStatement.setLong(6, patient.getAddress().getId());
            preparedStatement.setLong(7, patient.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                connection.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return patient;
    }

    @Override
    public Patient delete(Integer id) {
        Patient patient = null;
        Address address = null;

        try {
            AddressDaoH2 addressDaoH2 = new AddressDaoH2();
            connection =H2DBConnection.getConnection();

            patient = read(id);
            addressDaoH2.delete(Integer.valueOf(patient.getAddress().getId().toString()));

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM patients WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                connection.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return patient;
    }
}
