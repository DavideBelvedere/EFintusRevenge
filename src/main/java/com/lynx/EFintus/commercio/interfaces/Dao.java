package com.lynx.EFintus.commercio.interfaces;

import com.lynx.EFintus.commercio.classes.persistable.Persistable;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    List<T> getAll() throws SQLException;

    T save(T t) throws SQLException;

    T update(T t) throws SQLException;

    boolean delete(T t) throws SQLException;
}
