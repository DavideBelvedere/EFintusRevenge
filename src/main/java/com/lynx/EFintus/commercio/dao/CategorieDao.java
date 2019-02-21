package com.lynx.EFintus.commercio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lynx.EFintus.commercio.classes.Categoria;

public class CategorieDao extends GenericDao<Categoria> {

    private String TABLE_NAME = "categoria";

    public Categoria getById(int id) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from " + getTableName() + " where id = ?");
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();
	con.close();
	return fromResultSetToBean(rs);
    }

    @Override
    public List<Categoria> getAll() throws SQLException {
	List<Categoria> categorie = new ArrayList<Categoria>();

	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from " + getTableName());
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	    categorie.add(this.fromResultSetToBean(rs));
	}
	con.close();

	return categorie;
    }

    @Override
    public void save(Categoria categoria) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("insert into " + getTableAndColumns() + " values (?,?)");

	ps.setString(1, categoria.getNome());
	ps.setInt(2, categoria.getParentId());

	ps.executeUpdate();

	con.close();

    }

    @Override
    public void update(Categoria categoria) throws SQLException {

	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("update " + getTableName() + " set nome=?, ParentID=? WHERE id=?");
	ps.setString(1, categoria.getNome());
	ps.setInt(2, categoria.getParentId());
	ps.setInt(3, categoria.getId());

	ps.executeUpdate();

	con.close();

    }

    @Override
    public void delete(Categoria categoria) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("delete from " + getTableName() + " where id = ?");
	ps.setInt(1, categoria.getId());
	ps.executeUpdate();
	con.close();

    }

    @Override
    public Categoria fromResultSetToBean(ResultSet rs) throws SQLException {
	Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2), rs.getInt(3));
	return categoria;
    }

    @Override
    public String getTableName() {
	return TABLE_NAME;
    }

    @Override
    public String getColumns() {
	return "(nome , parentID)";
    }

}
