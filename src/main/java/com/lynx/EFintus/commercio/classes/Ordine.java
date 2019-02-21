package com.lynx.EFintus.commercio.classes;

import java.util.Date;

public class Ordine {

    private int id;
    private Date dataOrdine;
    private int idUtente;
    private String stato;
    private int idCorriere;
    private int idTrasporto;

    public Ordine(int id, Date dataOrdine, int idUtente, String stato, int idCorriere, int idTrasporto) {
	this.id = id;
	this.dataOrdine = dataOrdine;
	this.idUtente = idUtente;
	this.stato = stato;
	this.idCorriere = idCorriere;
	this.idTrasporto = idTrasporto;
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

    public int getIdUtente() {
	return idUtente;
    }

    public void setIdUtente(int idUtente) {
	this.idUtente = idUtente;
    }

    public String getStato() {
	return stato;
    }

    public void setStato(String stato) {
	this.stato = stato;
    }

    public int getIdCorriere() {
	return idCorriere;
    }

    public void setIdCorriere(int idCorriere) {
	this.idCorriere = idCorriere;
    }

    public int getIdTrasporto() {
	return idTrasporto;
    }

    public void setIdTrasporto(int idTrasporto) {
	this.idTrasporto = idTrasporto;
    }

}
