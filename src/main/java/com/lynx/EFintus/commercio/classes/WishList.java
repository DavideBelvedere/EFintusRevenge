package com.lynx.EFintus.commercio.classes;

public class WishList {

    private int id;
    private int utente;
    private String nome;

    public WishList(int id, int utente, String nome) {
        this.id = id;
        this.utente = utente;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUtente() {
        return utente;
    }

    public void setUtente(int utente) {
        this.utente = utente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
