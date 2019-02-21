package com.lynx.EFintus.commercio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lynx.EFintus.commercio.classes.Produttore;

public class ProduttoreDao extends GenericDao<Produttore> {

    private String TABLE_NAME = "produttore";

    public Produttore getByID(int id) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from " + getTableName() + " WHERE id = ?");
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();

	Produttore produttore = fromResultSetToBean(rs);
	con.close();

	return produttore;
    }

    @Override
    public List<Produttore> getAll() throws SQLException {
	List<Produttore> produttori = new ArrayList<Produttore>();

	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from " + getTableName());
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	    Produttore produttore = fromResultSetToBean(rs);
	    produttori.add(produttore);
	}
	con.close();

	return produttori;
    }

    @Override
    public void save(Produttore produttore) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con
		.prepareStatement("insert into " + getTableAndColumns() + " values (?,?,?,?,?,?,?,?)");

	ps.setString(1, produttore.getNome());
	ps.setString(2, produttore.getIndirizzo());
	ps.setString(3, produttore.getCitta());
	ps.setString(4, produttore.getCap());
	ps.setString(5, produttore.getTelefono());
	ps.setString(6, produttore.getEmail());
	ps.setString(7, produttore.getDescrizione());
	ps.setString(8, produttore.getPartitaIVA());

	int status = ps.executeUpdate();

	con.close();
    }

    @Override
    public void update(Produttore produttore) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("update" + getTableName()
		+ "set nome=?, indirizzo=?, citta=?, cap=?, telefono=?, email=?, descrizione=?, partitaIVA=? WHERE id=?");
	ps.setString(1, produttore.getNome());
	ps.setString(2, produttore.getIndirizzo());
	ps.setString(3, produttore.getCitta());
	ps.setString(4, produttore.getCap());
	ps.setString(5, produttore.getTelefono());
	ps.setString(6, produttore.getEmail());
	ps.setString(7, produttore.getDescrizione());
	ps.setString(8, produttore.getPartitaIVA());
	ps.setInt(9, produttore.getId());

	int status = ps.executeUpdate();

	con.close();
    }

    @Override
    public void delete(Produttore produttore) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("DELETE FROM" + getTableName() + "WHERE ID=?");
	ps.setInt(1, produttore.getId());
	ps.executeUpdate();

	con.close();
    }

    @Override
    public String getTableName() {
	return TABLE_NAME;
    }

    @Override
    public String getColumns() {
	return "(nome,indirizzo, citta, cap , telefono, email, descrizione, partitaIVA)";
    }

    @Override
    public Produttore fromResultSetToBean(ResultSet rs) throws SQLException {
	Produttore produttore = new Produttore(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
		rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
	return produttore;
    }
}
