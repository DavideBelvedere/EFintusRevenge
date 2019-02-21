package com.lynx.EFintus.commercio.dao;

import com.lynx.EFintus.commercio.classes.WishList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WishListDao extends GenericDao<WishList> {

    private String TABLE_NAME = "wishlist";

    public WishList getById(int id) throws SQLException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("select * from " + getTableName() + " where id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        con.close();
        return fromResultSetToBean(rs);

    }

    @Override
    public List<WishList> getAll() throws SQLException {
        List<WishList> wishLists = new ArrayList<WishList>();

        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("select * from " + getTableName());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            wishLists.add(this.fromResultSetToBean(rs));
        }

        con.close();

        return wishLists;

    }

    @Override
    public void save(WishList wishLists) throws SQLException {
        Connection con = getConnection();
        PreparedStatement ps = con
                .prepareStatement("insert into " + getTableAndColumns() + " values (?, ?)");

        ps.setInt(1, wishLists.getUtente());
        ps.setString(2, wishLists.getNome());

        int status = ps.executeUpdate();

        con.close();
    }

    @Override
    public void update(WishList wishLists) throws SQLException {

        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("update " + getTableName() + " set Utente=?, Nome=? WHERE id=?");
        ps.setInt(1, wishLists.getUtente());
        ps.setString(2, wishLists.getNome());
        ps.setInt(3, wishLists.getId());

        ps.executeUpdate();

        con.close();
    }

    @Override
    public void delete(WishList wishLists) throws SQLException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("delete from " + getTableName() + " where id = ?");
        ps.setInt(1, wishLists.getId());
        ps.executeUpdate();
        con.close();
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public String getColumns() {
        return "(Utente, Nome)";
    }

    @Override
    public WishList fromResultSetToBean(ResultSet rs) throws SQLException {
        WishList wishLists = new WishList(rs.getInt(1), rs.getInt(2), rs.getString(3));
        return wishLists;
    }
}
