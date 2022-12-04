package com.cvargas.dentalOffice.dentalOffice.dao;

import com.cvargas.dentalOffice.dentalOffice.dao.interfaces.IDaoCrud;
import com.cvargas.dentalOffice.dentalOffice.models.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Logger;

public class PatientDaoH2 implements IDaoCrud<Patient> {

    private static final Logger logger = Logger.getLogger(String.valueOf(DentistDaoH2.class));

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    @Override
    public Patient create(Patient patient) {
        return null;
    }

    @Override
    public List<Patient> readAll() {
        return null;
    }

    @Override
    public Patient read(int id) {
        return null;
    }

    @Override
    public Patient update(Patient patient) {
        return null;
    }

    @Override
    public Patient delete(int id) {
        return null;
    }
}
