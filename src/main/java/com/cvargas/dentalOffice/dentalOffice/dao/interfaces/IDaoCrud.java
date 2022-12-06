package com.cvargas.dentalOffice.dentalOffice.dao.interfaces;

import java.util.List;
import java.util.Optional;

public interface IDaoCrud<T> {

    public T create(T t);
    public List<T> readAll();
    public T read(Integer id);
    public T update(T t);
    public T delete(Integer id);


}
