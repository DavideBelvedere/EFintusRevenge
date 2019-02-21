package com.lynx.EFintus.commercio.classes;

public class OrdineProdotto {

    private int idProdotto;
    private int idOrdine;
    private int quantita;

    public OrdineProdotto(int idProdotto, int idOrdine, int quantita) {
        this.idProdotto = idProdotto;
        this.idOrdine = idOrdine;
        this.quantita = quantita;
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

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}
