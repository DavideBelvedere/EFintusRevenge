package com.lynx.EFintus.commercio.classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "metodo_pagamento")
public class MetodoPagamento {

    @Id
    @Column(name = "metodo_pagamento")
    private String metodoPagamento;

    @OneToMany(mappedBy = "fattura")
    private List<Fattura> fatture = new ArrayList<>();

    public MetodoPagamento() {

    }

    public String getMetodoPagamento() {
	return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
	this.metodoPagamento = metodoPagamento;
    }

    public List<Fattura> getFatture() {
	return fatture;
    }

    public void setFatture(List<Fattura> fatture) {
	this.fatture = fatture;
    }

}