package com.lynx.EFintus.commercio.classes;

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
@Table(name = "fattura")
public class Fattura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_ordine")
    private Ordine ordine;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "metodo_pagamento")
    private MetodoPagamento metodoPagamento;

    public Fattura() {
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Ordine getOrdine() {
	return ordine;
    }

    public void setOrdine(Ordine ordine) {
	this.ordine = ordine;
    }

    public MetodoPagamento getMetodoPagamento() {
	return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
	this.metodoPagamento = metodoPagamento;
    }
}
