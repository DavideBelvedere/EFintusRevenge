package com.lynx.EFintus.commercio.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lynx.EFintus.commercio.classes.Recensione;

public class RecensioneDao extends GenericDao<Recensione> {

    private String TABLE_NAME = "recensione";

    public Recensione getByID(int id_utente,int id_prodotto) throws SQLException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("select * from " + getTableName() + " WHERE ID_utente= ? AND ID_prodotto=?");
        ps.setInt(1, id_utente);
        ps.setInt(2, id_prodotto);
        ResultSet rs = ps.executeQuery();
        con.close();
        return fromResultSetToBean(rs);
    }

    @Override
    public List<Recensione> getAll() throws SQLException {
        List<Recensione> produttori = new ArrayList<Recensione>();

        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("select * from " + getTableName());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Recensione produttore = new Recensione(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
                    rs.getDate(6));
            produttori.add(produttore);
        }
        con.close();

        return produttori;
    }

    @Override
    public void save(Recensione recensione) throws SQLException {
        Connection con = getConnection();
        PreparedStatement ps = con
                .prepareStatement("insert into " + getTableAndColumns() + " values (?,?,?,?,?,?)");

        ps.setInt(1, recensione.getIdUtente());
        ps.setInt(2, recensione.getIdProdotto());
        ps.setInt(3, recensione.getIdOrdine());
        ps.setString(4, recensione.getDescrizione());
        ps.setInt(5, recensione.getVoto());
        ps.setDate(6, recensione.getData());

        int status = ps.executeUpdate();

        con.close();
    }

    @Override
    public void update(Recensione recensione) throws SQLException {
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement("update " + getTableName() + " set id_utente= ?, id_prodotto= ?, id_ordine= ?, descrizione= ?, voto= ?, data= ? WHERE id_utente= ? and id_prodotto = ?");
        ps.setInt(1, recensione.getIdUtente());
        ps.setInt(2, recensione.getIdProdotto());
        ps.setInt(3, recensione.getIdOrdine());
        ps.setString(4, recensione.getDescrizione());
        ps.setInt(5, recensione.getVoto());
        ps.setDate(6, recensione.getData());
        ps.setInt(7, recensione.getIdUtente());
        ps.setInt(8, recensione.getIdProdotto());

        int status = ps.executeUpdate();

        con.close();
    }

    @Override
    public void delete(Recensione recensione) throws SQLException {
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement("delete from " + getTableName() + " where id_utente= ? and id_prodotto = ?");
        ps.setInt(1, recensione.getIdUtente());
        ps.setInt(2, recensione.getIdProdotto());

        int status = ps.executeUpdate();

        con.close();
    }

    @Override
    public Recensione fromResultSetToBean(ResultSet t) throws SQLException {
        return null;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public String getColumns() {
        return "(ID_utente,ID_prodotto,ID_ordine,descrizione,voto,data)";
    }
}
