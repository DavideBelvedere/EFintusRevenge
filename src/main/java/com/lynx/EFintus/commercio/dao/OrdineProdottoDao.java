package com.lynx.EFintus.commercio.dao;


import com.lynx.EFintus.commercio.classes.OrdineProdotto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdineProdottoDao extends GenericDao<OrdineProdotto> {

    private String TABLE_NAME = "ordine_prodotto";

    public OrdineProdotto getById(int idProdotto, int idOrdine) throws SQLException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("select * from " + getTableName() + " where id_prodotto = ? and id_ordine = ?");
        ps.setInt(1, idProdotto);
        ps.setInt(2, idOrdine);
        ResultSet rs = ps.executeQuery();
        con.close();
        return fromResultSetToBean(rs);

    }

    @Override
    public List<OrdineProdotto> getAll() throws SQLException {
        List<OrdineProdotto> ordersProducts = new ArrayList<OrdineProdotto>();

        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("select * from " + getTableName());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ordersProducts.add(this.fromResultSetToBean(rs));
        }

        con.close();

        return ordersProducts;

    }

    @Override
    public void save(OrdineProdotto ordersProducts) throws SQLException {
        Connection con = getConnection();
        PreparedStatement ps = con
                .prepareStatement("insert into " + getTableAndColumns() + " values (?)");

        ps.setInt(1, ordersProducts.getQuantita());

        int status = ps.executeUpdate();

        con.close();
    }

    @Override
    public void update(OrdineProdotto ordersProducts) throws SQLException {

        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("update " + getTableName() + " set quantita=? WHERE id_prodotto = ? and id_ordine = ?");
        ps.setInt(1, ordersProducts.getQuantita());
        ps.setInt(2, ordersProducts.getIdProdotto());
        ps.setInt(3, ordersProducts.getIdOrdine());


        ps.executeUpdate();

        con.close();
    }

    @Override
    public void delete(OrdineProdotto ordersProducts) throws SQLException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("delete from " + getTableName() + " where id_prodotto = ? and id_ordine = ?");
        ps.setInt(1, ordersProducts.getIdProdotto());
        ps.setInt(2, ordersProducts.getIdOrdine());
        ps.executeUpdate();
        con.close();
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public String getColumns() {
        return "(quantita)";
    }

    @Override
    public OrdineProdotto fromResultSetToBean(ResultSet rs) throws SQLException {
        OrdineProdotto ordersProducts = new OrdineProdotto(rs.getInt(1), rs.getInt(2), rs.getInt(3));
        return ordersProducts;
    }
}
