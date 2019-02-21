package com.lynx.EFintus.commercio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lynx.EFintus.commercio.classes.MetodoPagamento;

public class MetodoPagamentoDao extends GenericDao<MetodoPagamento> {

    private static String TABLE_NAME = "metodo_pagamento";

    public MetodoPagamento getByName(String name) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from " + getTableName());
	ResultSet rs = ps.executeQuery();
	MetodoPagamento metodoPagamento = this.fromResultSetToBean(rs);
	con.close();
	return metodoPagamento;
    }

    @Override
    public List<MetodoPagamento> getAll() throws SQLException {
	List<MetodoPagamento> metodoPagamento = new ArrayList<MetodoPagamento>();

	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from " + getTableName());
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	    metodoPagamento.add(this.fromResultSetToBean(rs));
	}

	con.close();

	return metodoPagamento;
    }

    @Override
    public void save(MetodoPagamento metodoPagamento) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("insert into " + getTableAndColumns() + " values (?)");

	ps.setString(1, metodoPagamento.getMetodoPagamento());

	ps.executeUpdate();

	con.close();

    }

    /**
     * Not implemented method, use delete and save
     */
    @Override
    public void update(MetodoPagamento metodoPagamento) throws SQLException {

	// Not implemented

    }

    @Override
    public void delete(MetodoPagamento metodoPagamento) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("delete from " + getTableName() + " where metodo_pagamento = ?");
	ps.setString(1, metodoPagamento.getMetodoPagamento());
	ps.executeUpdate();
	con.close();
    }

    @Override
    public MetodoPagamento fromResultSetToBean(ResultSet rs) throws SQLException {
	MetodoPagamento metodoPagamento = new MetodoPagamento(rs.getString(1));
	return metodoPagamento;
    }

    @Override
    public String getTableName() {
	return TABLE_NAME;
    }

    @Override
    public String getColumns() {
	return ("metodo_pagamento");
    }

}
