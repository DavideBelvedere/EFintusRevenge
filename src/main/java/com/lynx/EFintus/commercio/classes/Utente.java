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

import logistica.entities.Ordine;

@Entity
@Table(name = "utente")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Cognome")
    private String cognome;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Indirizzo")
    private String indirizzo;

    @Column(name = "Citta")
    private String citta;

    @Column(name = "CAP")
    private String cap;

    @Column(name = "Stato")
    private String stato;

    @Column(name = "Id_Trasporto")
    private String telefono;

    @Column(name = "PartitaIva")
    private String partitaIva;

    @OneToMany(mappedBy = "utente")
    private List<Ordine> ordini = new ArrayList<>();

    @OneToMany(mappedBy = "wishlist")
    private List<WishList> wishlists = new ArrayList<>();

    @OneToMany(mappedBy = "recensione")
    private List<Recensione> recensioni = new ArrayList<>();

    public Utente() {

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

    public String getCognome() {
	return cognome;
    }

    public void setCognome(String cognome) {
	this.cognome = cognome;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
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

    public String getStato() {
	return stato;
    }

    public void setStato(String stato) {
	this.stato = stato;
    }

    public String getTelefono() {
	return telefono;
    }

    public void setTelefono(String telefono) {
	this.telefono = telefono;
    }

    public String getPartitaIva() {
	return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
	this.partitaIva = partitaIva;
    }

    public List<Ordine> getOrdini() {
	return ordini;
    }

    public void setOrdini(List<Ordine> ordini) {
	this.ordini = ordini;
    }

    public List<WishList> getWishlists() {
	return wishlists;
    }

    public void setWishlists(List<WishList> wishlists) {
	this.wishlists = wishlists;
    }

}
