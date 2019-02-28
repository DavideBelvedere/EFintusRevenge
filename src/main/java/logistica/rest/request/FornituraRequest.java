package logistica.rest.request;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import logistica.entities.Fornitore;
import logistica.entities.Prodotto;

import java.io.Serializable;
import java.util.Date;

public class FornituraRequest implements Serializable {
    private Integer id;

    private Integer quantita;

    private Date date;

    private Prodotto prodotto;

    private Fornitore fornitore;

    @JsonGetter
    public Integer getId() {
        return id;
    }

    @JsonSetter
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonGetter
    public Integer getQuantita() {
        return quantita;
    }

    @JsonSetter
    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    @JsonGetter
    public Date getDate() {
        return date;
    }

    @JsonSetter
    public void setDate(Date date) {
        this.date = date;
    }

    @JsonGetter
    public Prodotto getProdotto() {
        return prodotto;
    }

    @JsonSetter
    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    @JsonGetter
    public Fornitore getFornitore() {
        return fornitore;
    }

    @JsonSetter
    public void setFornitore(Fornitore fornitore) {
        this.fornitore = fornitore;
    }


}
