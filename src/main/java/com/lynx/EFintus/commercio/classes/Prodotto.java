package com.lynx.EFintus.commercio.classes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prodotto")
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Nome")
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Produttore")
    private Integer idProduttore;

    @Column(name = "Prezzo")
    private Double prezzo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Categorie")
    private Integer idCategorie;

    @Column(name = "Descrizione")
    private String descrizione;

    @Column(name = "Misure")
    private String misure;

    @Column(name = "Peso")
    private Double peso;

    @Column(name = "Colore")
    private String colore;

    @Column(name = "pathImmagini")
    private String pathImmagini;

    @Column(name = "DataInizioValidita")
    private Date dataInizioValidita;

    @Column(name = "DataFineValidita")
    private Date dataFineValidita;

    private List<WishlistProdotto> wishlistProdottos = new ArrayList<>();
    private List<OrdineProdotto> ordineProdottos = new ArrayList<>();
    private List<TagsProdotto> tagsProdottos = new ArrayList<>();
    private List<Recensione> recensioni = new ArrayList<>();

    public Prodotto() {
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

    public Integer getIdProduttore() {
	return idProduttore;
    }

    public void setIdProduttore(Integer idProduttore) {
	this.idProduttore = idProduttore;
    }

    public Double getPrezzo() {
	return prezzo;
    }

    public void setPrezzo(Double prezzo) {
	this.prezzo = prezzo;
    }

    public Integer getIdCategorie() {
	return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
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

    public Double getPeso() {
	return peso;
    }

    public void setPeso(Double peso) {
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
