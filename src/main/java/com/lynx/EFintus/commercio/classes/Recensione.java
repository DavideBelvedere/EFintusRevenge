package com.lynx.EFintus.commercio.classes;

import java.sql.Date;

public class Recensione {

    private int idUtente;
    private int idProdotto;
    private int idOrdine;
    private String descrizione;
    private int voto;
    private Date data;

    public Recensione(int idUtente, int idProdotto, int idOrdine, String descrizione, int voto, Date data) {
        this.idUtente = idUtente;
        this.idProdotto = idProdotto;
        this.idOrdine = idOrdine;
        this.descrizione = descrizione;
        this.voto = voto;
        this.data = data;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
