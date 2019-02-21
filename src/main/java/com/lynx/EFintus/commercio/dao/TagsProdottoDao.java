package com.lynx.EFintus.commercio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lynx.EFintus.commercio.classes.TagsProdotto;

public class TagsProdottoDao extends GenericDao<TagsProdotto> {

    private static String TABLE_NAME = "tags_prodotto";

    public List<TagsProdotto> getByIdTags(int idTags) throws SQLException {
	List<TagsProdotto> tagsProdotti = new ArrayList<TagsProdotto>();

	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from " + getTableName() + " where ID_Tags = ?");
	ps.setInt(1, idTags);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	    tagsProdotti.add(this.fromResultSetToBean(rs));
	}

	con.close();

	return tagsProdotti;
    }

    public List<TagsProdotto> getByIdProdotto(int idProdotto) throws SQLException {

	List<TagsProdotto> tagsProdotti = new ArrayList<TagsProdotto>();

	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from " + getTableName() + " where ID_Prodotto = ?");
	ps.setInt(1, idProdotto);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	    tagsProdotti.add(this.fromResultSetToBean(rs));
	}

	con.close();

	return tagsProdotti;
    }

    @Override
    public List<TagsProdotto> getAll() throws SQLException {

	List<TagsProdotto> tagsProdotti = new ArrayList<TagsProdotto>();

	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from " + getTableName());
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	    tagsProdotti.add(this.fromResultSetToBean(rs));
	}

	con.close();

	return tagsProdotti;
    }

    @Override
    public void save(TagsProdotto tagsProdotto) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("insert into " + getTableAndColumns() + " values (?,?)");

	ps.setInt(1, tagsProdotto.getIdTags());
	ps.setInt(2, tagsProdotto.getIdProdotto());

	ps.executeUpdate();

	con.close();

    }

    /**
     * Not implemented method, use delete and save
     */
    @Override
    public void update(TagsProdotto tagsProdotto) throws SQLException {
	// TODO Auto-generated method stub

    }

    @Override
    public void delete(TagsProdotto tagsProdotto) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con
		.prepareStatement("delete from " + getTableName() + " where (ID_Tags = ? AND ID_Prodotto = ?)");
	ps.setInt(1, tagsProdotto.getIdTags());
	ps.setInt(2, tagsProdotto.getIdProdotto());
	ps.executeUpdate();
	con.close();

    }

    @Override
    public TagsProdotto fromResultSetToBean(ResultSet rs) throws SQLException {
	return new TagsProdotto(rs.getInt(1), rs.getInt(2));
    }

    @Override
    public String getTableName() {
	return TABLE_NAME;
    }

    @Override
    public String getColumns() {
	return "(ID_Tags, ID_Prodotto)";
    }

}
