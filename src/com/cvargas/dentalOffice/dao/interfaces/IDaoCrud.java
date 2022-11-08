package com.cvargas.dentalOffice.dao.interfaces;

import java.util.List;

public interface IDaoCrud<T> {

    public T create(T t);
    public List<T> readAll();
    public T read(int id);
    public T update(T t);
    public void delete(int id);


}
