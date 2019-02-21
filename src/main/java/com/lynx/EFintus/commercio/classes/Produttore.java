package com.lynx.EFintus.commercio.classes;

public class Produttore {

    private int id;
    private String nome;
    private String indirizzo;
    private String citta;
    private String cap;
    private String telefono;
    private String email;
    private String descrizione;
    private String partitaIVA;

    public Produttore(int id, String nome, String indirizzo, String citta, String cap, String telefono, String email, String descrizione, String partitaIVA) {
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.cap = cap;
        this.telefono = telefono;
        this.email = email;
        this.descrizione = descrizione;
        this.partitaIVA = partitaIVA;
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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getPartitaIVA() {
        return partitaIVA;
    }

    public void setPartitaIVA(String partitaIVA) {
        this.partitaIVA = partitaIVA;
    }
}
