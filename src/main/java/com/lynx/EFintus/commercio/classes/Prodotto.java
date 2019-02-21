package com.lynx.EFintus.commercio.classes;


import java.sql.Date;

public class Prodotto {

    private int id;
    private String nome;
    private int idProduttore;
    private float prezzo;
    private int idCategorie;
    private String descrizione;
    private String misure;
    private float peso;
    private String colore;
    private String pathImmagini;
    private Date dataInizioValidita;
    private Date dataFineValidita;

    public Prodotto(int id, String nome, int idProduttore, float prezzo, int idCategorie, String descrizione, String misure, float peso, String colore, String pathImmagini, Date dataInizioValidita, Date dataFineValidita) {
        this.id = id;
        this.nome = nome;
        this.idProduttore = idProduttore;
        this.prezzo = prezzo;
        this.idCategorie = idCategorie;
        this.descrizione = descrizione;
        this.misure = misure;
        this.peso = peso;
        this.colore = colore;
        this.pathImmagini = pathImmagini;
        this.dataInizioValidita = dataInizioValidita;
        this.dataFineValidita = dataFineValidita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdProduttore() {
        return idProduttore;
    }

    public void setIdProduttore(int idProduttore) {
        this.idProduttore = idProduttore;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getMisure() {
        return misure;
    }

    public void setMisure(String misure) {
        this.misure = misure;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getPathImmagini() {
        return pathImmagini;
    }

    public void setPathImmagini(String pathImmagini) {
        this.pathImmagini = pathImmagini;
    }

    public Date getDataInizioValidita() {
        return dataInizioValidita;
    }

    public void setDataInizioValidita(Date dataInizioValidita) {
        this.dataInizioValidita = dataInizioValidita;
    }

    public Date getDataFineValidita() {
        return dataFineValidita;
    }

    public void setDataFineValidita(Date dateFineValidita) {
        this.dataFineValidita = dateFineValidita;
    }
}
