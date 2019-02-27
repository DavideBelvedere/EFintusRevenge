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
@Table(name = "produttore")
public class Produttore implements Persistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Indirizzo")
    private String indirizzo;

    @Column(name = "Citt�")
    private String citta;

    @Column(name = "cap")
    private String cap;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name = "Email")
    private String email;

    @Column(name = "Descrizione")
    private String descrizione;

    @Column(name = "PartitaIVA")
    private String partitaIVA;

    @OneToMany(mappedBy = "produttore")
    List<Prodotto> prodotti = new ArrayList<Prodotto>();

    public Produttore() {
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
