package com.lynx.EFintus.commercio.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    List<T> getAll() throws SQLException;

    void save(T t) throws SQLException;

    void update(T t) throws SQLException;

    void delete(T t) throws SQLException;

    T fromResultSetToBean(ResultSet t) throws SQLException;
}
