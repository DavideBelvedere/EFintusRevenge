package com.lynx.EFintus.commercio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lynx.EFintus.commercio.classes.Utente;

public class UtenteDao extends GenericDao<Utente> {

    private String TABLE_NAME = "utente";

    public Utente getByID(int id) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from " + getTableName() + " where id = ?");
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();
	con.close();
	return fromResultSetToBean(rs);

    }

    @Override
    public List<Utente> getAll() throws SQLException {
	List<Utente> utenti = new ArrayList<Utente>();

	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from " + getTableName());
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	    utenti.add(this.fromResultSetToBean(rs));
	}
	con.close();

	return utenti;

    }

    @Override
    public void save(Utente utente) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con
		.prepareStatement("insert into " + getTableAndColumns() + " values (?,?,?,?,?,?,?,?,?,?)");

	ps.setString(1, utente.getNome());
	ps.setString(2, utente.getCognome());
	ps.setString(3, utente.getEmail());
	ps.setString(4, utente.getPassword());
	ps.setString(5, utente.getIndirizzo());
	ps.setString(6, utente.getCitta());
	ps.setString(7, utente.getCap());
	ps.setString(8, utente.getStato());
	ps.setString(9, utente.getTelefono());
	ps.setString(10, utente.getPartitaIva());

	ps.executeUpdate();

	con.close();
    }

    @Override
    public void update(Utente utente) throws SQLException {

	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("update " + getTableName()
		+ " set Nome=?, Cognome=?, Email=?, Password=?, Indirizzo=?, Città=?, CAP=?, Stato=?, Telefono=?, PartitaIVA=? WHERE id=?");
	ps.setString(1, utente.getNome());
	ps.setString(2, utente.getCognome());
	ps.setString(3, utente.getEmail());
	ps.setString(4, utente.getPassword());
	ps.setString(5, utente.getIndirizzo());
	ps.setString(6, utente.getCitta());
	ps.setString(7, utente.getCap());
	ps.setString(8, utente.getStato());
	ps.setString(9, utente.getTelefono());
	ps.setString(10, utente.getPartitaIva());
	ps.setInt(11, utente.getId());

	ps.executeUpdate();

	con.close();
    }

    @Override
    public void delete(Utente utente) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("delete from " + getTableName() + " where id = ?");
	ps.setInt(1, utente.getId());
	ps.executeUpdate();
	con.close();
    }

    @Override
    public String getTableName() {
	return TABLE_NAME;
    }

    @Override
    public String getColumns() {
	return "(Nome, Cognome, Email, Password, Indirizzo, Città, CAP, Stato, Telefono, PartitaIVA)";
    }

    @Override
    public Utente fromResultSetToBean(ResultSet rs) throws SQLException {
	Utente utente = new Utente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
		rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
	return utente;
    }

}
