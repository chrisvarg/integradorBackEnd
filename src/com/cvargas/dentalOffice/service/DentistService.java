package com.cvargas.dentalOffice.service;

import com.cvargas.dentalOffice.dao.interfaces.IDaoCrud;
import com.cvargas.dentalOffice.models.Dentist;

import java.util.List;

public class DentistService {

    private IDaoCrud<Dentist> dentistDao;

    public DentistService() {
    }

    public DentistService(IDaoCrud<Dentist> dentistDao) {
        this.dentistDao = dentistDao;
    }

    public void setDentistDao(IDaoCrud<Dentist> dentistDao) {
        this.dentistDao = dentistDao;
    }

    public Dentist create(Dentist dentist) {
        return dentistDao.create(dentist);
    }

    public List<Dentist> readAll() {
        return dentistDao.readAll();
    }

    public Dentist read(int id) {
        return dentistDao.read(id);
    }

    public Dentist update(Dentist dentist) {
        return dentistDao.update(dentist);
    }


}
