package com.lynx.EFintus.commercio.classes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lynx.EFintus.commercio.classes.persistable.Persistable;
import com.lynx.EFintus.commercio.classes.primarykeys.OrdineProdottoPK;

@Entity
@Table(name = "ordine_prodotto")
@IdClass(OrdineProdottoPK.class)
public class OrdineProdotto implements Persistable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_prodotto")
    private Prodotto prodotto;
    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_ordine")
    private Ordine ordine;

    @Column(name = "Quantita")
    private Integer quantita;

    public OrdineProdotto() {
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

    public Integer getQuantita() {
	return quantita;
    }

    public void setQuantita(Integer quantita) {
	this.quantita = quantita;
    }
}
