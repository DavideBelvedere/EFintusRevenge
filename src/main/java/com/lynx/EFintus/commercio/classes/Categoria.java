package com.lynx.EFintus.commercio.classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lynx.EFintus.commercio.classes.persistable.Persistable;

@Entity
@Table(name = "categoria")
public class Categoria implements Persistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "parentID")
    private Integer parentId;

    @OneToMany(mappedBy = "prodotto")
    private List<Prodotto> prodotti = new ArrayList<>();

    public Categoria() {
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public Integer getParentId() {
	return parentId;
    }

    public void setParentId(Integer parentId) {
	this.parentId = parentId;
    }

    public List<Prodotto> getProdotti() {
	return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
	this.prodotti = prodotti;
    }

}
