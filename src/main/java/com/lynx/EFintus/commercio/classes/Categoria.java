package com.lynx.EFintus.commercio.classes;

public class Categoria {

    private int id;
    private String nome;
    private int parentId;

    public Categoria(int id, String nome, int parentId) {
        this.id = id;
        this.nome = nome;
        this.parentId = parentId;
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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
