package com.lynx.EFintus.commercio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lynx.EFintus.commercio.classes.WishlistProdotto;

public class WishlistProdottoDao extends GenericDao<WishlistProdotto> {

    private static String TABLE_NAME = "wishlist_prodotto";

    public List<WishlistProdotto> getByIdWishlist(int idWishlist) throws SQLException {

	List<WishlistProdotto> wishlistProdotti = new ArrayList<WishlistProdotto>();

	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from " + getTableName() + " where ID_Wishlist = ?");
	ps.setInt(1, idWishlist);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	    wishlistProdotti.add(this.fromResultSetToBean(rs));
	}

	con.close();

	return wishlistProdotti;
    }

    public List<WishlistProdotto> getByIdProdotto(int idProdotto) throws SQLException {

	List<WishlistProdotto> wishlistProdotti = new ArrayList<WishlistProdotto>();

	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from " + getTableName() + " where ID_Prodotto = ?");
	ps.setInt(1, idProdotto);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	    wishlistProdotti.add(this.fromResultSetToBean(rs));
	}

	con.close();

	return wishlistProdotti;
    }

    @Override
    public List<WishlistProdotto> getAll() throws SQLException {
	List<WishlistProdotto> wishlistProdotti = new ArrayList<WishlistProdotto>();

	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from " + getTableName());
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	    wishlistProdotti.add(this.fromResultSetToBean(rs));
	}

	con.close();

	return wishlistProdotti;

    }

    @Override
    public void save(WishlistProdotto wishlistProdotto) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("insert into " + getTableAndColumns() + " values (?,?,?)");

	ps.setInt(1, wishlistProdotto.getIdWishlist());
	ps.setInt(2, wishlistProdotto.getIdProdotto());
	ps.setDate(3, wishlistProdotto.getDataInserimento());

	ps.executeUpdate();

	con.close();

    }

    /**
     * Not implemented method, use delete and save
     */
    @Override
    public void update(WishlistProdotto t) throws SQLException {
	// TODO Auto-generated method stub

    }

    @Override
    public void delete(WishlistProdotto wishlistProdotto) throws SQLException {
	Connection con = getConnection();
	PreparedStatement ps = con
		.prepareStatement("delete from " + getTableName() + " where (ID_Wishlist = ? AND ID_Prodotto = ?)");
	ps.setInt(1, wishlistProdotto.getIdWishlist());
	ps.setInt(2, wishlistProdotto.getIdProdotto());
	ps.executeUpdate();
	con.close();

    }

    @Override
    public WishlistProdotto fromResultSetToBean(ResultSet rs) throws SQLException {
	return new WishlistProdotto(rs.getInt(1), rs.getInt(2), rs.getDate(3));
    }

    @Override
    public String getTableName() {
	return TABLE_NAME;
    }

    @Override
    public String getColumns() {
	return "(ID_Wishlist, ID_Prodotto, DataInserimento)";
    }

}
