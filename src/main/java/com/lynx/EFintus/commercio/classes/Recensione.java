package com.lynx.EFintus.commercio.classes;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lynx.EFintus.commercio.classes.primarykeys.RecensionePK;

@Entity
@Table(name = "tags_prodotto")
@IdClass(RecensionePK.class)
public class Recensione {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Utente")
    private Utente utente;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Prodotto")
    private Prodotto prodotto;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Ordine")
    private Ordine ordine;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "voto")
    private Integer voto;

    @Column(name = "data")
    private Date data;

    public Recensione() {
    }

    public Utente getUtente() {
	return utente;
    }

    public void setUtente(Utente utente) {
	this.utente = utente;
    }

    public Prodotto getProdotto() {
	return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
	this.prodotto = prodotto;
    }

    public Ordine getOrdine() {
	return ordine;
    }

    public void setOrdine(Ordine ordine) {
	this.ordine = ordine;
    }

    public String getDescrizione() {
	return descrizione;
    }

    public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
    }

    public Integer getVoto() {
	return voto;
    }

    public void setVoto(Integer voto) {
	this.voto = voto;
    }

    public Date getData() {
	return data;
    }

    public void setData(Date data) {
	this.data = data;
    }
}
