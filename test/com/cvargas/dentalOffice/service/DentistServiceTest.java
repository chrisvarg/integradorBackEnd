package com.cvargas.dentalOffice.service;

import com.cvargas.dentalOffice.dao.DentistDaoH2;
import com.cvargas.dentalOffice.models.Dentist;
import com.cvargas.dentalOffice.utils.H2DBConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DentistServiceTest {

    private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    DentistDaoH2 dentistDaoH2 = new DentistDaoH2();

    private DentistService dentistService = new DentistService(dentistDaoH2);

    @Test
    public void testCrearDentist() {

        // Dado
        Dentist dentist = new Dentist("Carlos", "Martinez", "52f4567843");


        // Cuando
        boolean result = false;
        boolean resultadoEsperado = true;
        try {
            conn = H2DBConnection.getConnection();
            dentistService.create(dentist).getName();

            result = true;
        }  catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            try {
                //TODO: preguntarle al profe que es mejor usar connection.close o preparedStatement.close();
//                if (connection != null &&)
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        // Entonces
        Assertions.assertEquals(resultadoEsperado, result);


    }

    @Test
    public void testReadAllDentist() {

        // Dado

        // Cuando
        int result = 0;
        int resultadoEsperado = 1;
        try {
            conn = H2DBConnection.getConnection();
            result = dentistService.readAll().size();

        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //TODO: preguntarle al profe que es mejor usar connection.close o preparedStatement.close();
//                if (connection != null &&)
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // Entonces
        Assertions.assertEquals(resultadoEsperado, result);


    }

    @Test
    public void testReadOneDentist() {
        // Dado
        Dentist dentist = null;


        // Cuando
        String result = "";
        String resultadoEsperado = "Marcos Triana";
        try {
            conn = H2DBConnection.getConnection();
            dentist = dentistService.read(1);

            result = dentist.getName() + " " + dentist.getLastName();
        }  catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                //TODO: preguntarle al profe que es mejor usar connection.close o preparedStatement.close();
//                if (connection != null &&)
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        // Entonces
        Assertions.assertEquals(resultadoEsperado, result);
    }
}