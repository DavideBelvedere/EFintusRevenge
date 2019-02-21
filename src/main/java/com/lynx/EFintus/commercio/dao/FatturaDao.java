package com.lynx.EFintus.commercio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lynx.EFintus.commercio.classes.Fattura;

public class FatturaDao extends GenericDao<Fattura> {

    private String TABLE_NAME = "fattura";

    public Fattura getById(int id) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from " + getTableName() + " where id = ?");
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();
	con.close();
	return fromResultSetToBean(rs);
    }

    @Override
    public List<Fattura> getAll() throws SQLException {
	List<Fattura> fatture = new ArrayList<Fattura>();

	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from " + getTableName());
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	    fatture.add(this.fromResultSetToBean(rs));
	}
	con.close();

	return fatture;
    }

    @Override
    public void save(Fattura fattura) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("insert into " + getTableAndColumns() + " values (?,?)");

	ps.setInt(1, fattura.getIdOrdine());
	ps.setString(2, fattura.getMetodoPagamento());

	ps.executeUpdate();

	con.close();

    }

    @Override
    public void update(Fattura fattura) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("update " + getTableName() + " set nome=?, ParentID=? WHERE id=?");
	ps.setInt(1, fattura.getIdOrdine());
	ps.setString(2, fattura.getMetodoPagamento());
	ps.setInt(3, fattura.getId());

	ps.executeUpdate();

	con.close();

    }

    @Override
    public void delete(Fattura fattura) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("delete from " + getTableName() + " where id = ?");
	ps.setInt(1, fattura.getId());
	ps.executeUpdate();
	con.close();

    }

    @Override
    public Fattura fromResultSetToBean(ResultSet rs) throws SQLException {
	Fattura fattura = new Fattura(rs.getInt(1), rs.getInt(2), rs.getString(3));
	return fattura;
    }

    @Override
    public String getTableName() {
	return TABLE_NAME;
    }

    @Override
    public String getColumns() {
	return "(Id_ordine, Metodo_pagamento)";
    }

}
