package com.lynx.EFintus.commercio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lynx.EFintus.commercio.classes.Ordine;

public class OrdineDao extends GenericDao<Ordine> {

    private static String TABLE_NAME = "ordine";

    @Override
    public List<Ordine> getAll() throws SQLException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void save(Ordine t) throws SQLException {
	// TODO Auto-generated method stub

    }

    @Override
    public void update(Ordine t) throws SQLException {
	// TODO Auto-generated method stub

    }

    @Override
    public void delete(Ordine t) throws SQLException {
	// TODO Auto-generated method stub

    }

    @Override
    public Ordine fromResultSetToBean(ResultSet t) throws SQLException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String getTableName() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String getColumns() {
	return "(Id, Data_ordine, Id_utente, Stato, Id_Corriere, Id_Trasporto)";
    }

}
