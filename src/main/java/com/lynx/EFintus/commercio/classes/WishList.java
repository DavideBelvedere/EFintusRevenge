package com.lynx.EFintus.commercio.classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "wishlist")
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "Utente")
    private Utente utente;

    @Column(name = "Nome")
    private String nome;

    @OneToMany(mappedBy = "wishlist_prodotto")
    private List<WishlistProdotto> wishlistProdottos = new ArrayList<>();

    public WishList() {
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Utente getUtente() {
	return utente;
    }

    public void setUtente(Utente utente) {
	this.utente = utente;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public List<WishlistProdotto> getWishlistProdottos() {
	return wishlistProdottos;
    }

    public void setWishlistProdottos(List<WishlistProdotto> wishlistProdottos) {
	this.wishlistProdottos = wishlistProdottos;
    }

}
