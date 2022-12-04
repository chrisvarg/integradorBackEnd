package com.cvargas.dentalOffice.dentalOffice.dao;

import com.cvargas.dentalOffice.dentalOffice.dao.interfaces.IDaoCrud;
import com.cvargas.dentalOffice.dentalOffice.models.Dentist;
import com.cvargas.dentalOffice.dentalOffice.utils.H2DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class DentistDaoH2 implements IDaoCrud<Dentist> {

    private static final Logger logger = Logger.getLogger(String.valueOf(DentistDaoH2.class));

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    @Override
    public Dentist create(Dentist dentist) {

        try {
            connection = H2DBConnection.getConnection();

            logger.info("Creando usuario...");
            // creamos la query de crear dentists de forma dinamica.
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO DENTISTS(name, last_name, license) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(1, dentist.getName());
            preparedStatement.setString(2, dentist.getLastName());
            preparedStatement.setString(3, dentist.getLicense());

            // ejecutamos la query
            preparedStatement.executeUpdate();

            ResultSet keys = preparedStatement.getGeneratedKeys();
            while (keys.next()) {
                dentist.setId(keys.getInt(1));
            }

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

        return dentist;
    }

    @Override
    public List<Dentist> readAll() {

        List<Dentist> dentistList = new ArrayList<>();
        try {
            connection = H2DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM dentists");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                String license = resultSet.getString("license");

                dentistList.add(new Dentist(id, name, lastName, license));
            }

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

        return dentistList;
    }

    @Override
    public Dentist read(int id) {

        Dentist dentist = null;

        try {
            connection = H2DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM dentists WHERE id=?;");
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idDentist = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                String license = resultSet.getString("license");

                dentist = new Dentist(idDentist, name, lastName, license);

            }

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

        return dentist;
    }

    //TODO terminar el CRUD, hacer logs y tests... a todo
    @Override
    public Dentist update(Dentist dentist) {

        try {
            connection = H2DBConnection.getConnection();

            preparedStatement = connection.prepareStatement("UPDATE DENTISTS SET NAME = ?, LAST_NAME = ?, LICENSE = ? WHERE id = ?;");
            /*UPDATE DENTISTS SET NAME  = 'sANTIAGO'
                    , LAST_NAME = 'SANCHEX', LICENSE = '1234567843' WHERE id = 1;*/
            preparedStatement.setString(1, dentist.getName());
            preparedStatement.setString(2, dentist.getLastName());
            preparedStatement.setString(3, dentist.getLicense());
            preparedStatement.setInt(4, dentist.getId());

            System.out.println(preparedStatement.executeUpdate());



            logger.info("La información ha sido actualizado");
        } catch (Exception e) {
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
        return dentist;
    }

    // TODO: crear el service, test
    @Override
    public Dentist delete(int id) {

        Dentist dentist = null;

        try {
            dentist = read(id);
            connection = H2DBConnection.getConnection();

            System.out.println(dentist);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM dentists WHERE id=?");
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

        return dentist;

    }

}
