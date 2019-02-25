package com.lynx.EFintus.commercio.classes;

import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import logistica.entities.Corriere;

@Entity
@Table(name = "ordine")
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Data_ordine")
    private Date dataOrdine;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "Id_utente")
    private Utente utente;

    @Column(name = "Stato")
    private String stato;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Corriere")
    private Corriere corriere;

    @Column(name = "Id_Trasporto")
    private int idTrasporto;

    @OneToMany(mappedBy = "recensione")
    private List<Recensione> recensioni;

    public Ordine() {
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public Date getDataOrdine() {
	return dataOrdine;
    }

    public void setDataOrdine(Date dataOrdine) {
	this.dataOrdine = dataOrdine;
    }

    public Utente getUtente() {
	return utente;
    }

    public void setUtente(Utente utente) {
	this.utente = utente;
    }

    public String getStato() {
	return stato;
    }

    public void setStato(String stato) {
	this.stato = stato;
    }

    public Corriere getCorriere() {
	return corriere;
    }

    public void setCorriere(Corriere corriere) {
	this.corriere = corriere;
    }

    public int getIdTrasporto() {
	return idTrasporto;
    }

    public void setIdTrasporto(int idTrasporto) {
	this.idTrasporto = idTrasporto;
    }

}
