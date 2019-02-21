package com.lynx.EFintus.commercio.classes;

public class Fattura {

    private int id;
    private int idOrdine;
    private String metodoPagamento;

    public Fattura(int id, int idOrdine, String metodoPagamento) {
        this.id = id;
        this.idOrdine = idOrdine;
        this.metodoPagamento = metodoPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}
