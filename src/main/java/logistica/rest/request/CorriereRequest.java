package logistica.rest.request;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import logistica.entities.Ordine;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CorriereRequest implements Serializable {
    private Integer id;

    private String nome;

    private String via;

    private String citta;

    private String n_civico;

    private String cap;

    private List<Ordine> ordini = new ArrayList<>();

    @JsonGetter
    public Integer getId() {
        return id;
    }

    @JsonGetter
    public String getNome() {
        return nome;
    }

    @JsonGetter
    public String getVia() {
        return via;
    }

    @JsonGetter
    public String getCitta() {
        return citta;
    }

    @JsonGetter
    public String getN_civico() {
        return n_civico;
    }

    @JsonGetter
    public String getCap() {
        return cap;
    }

    @JsonGetter
    public List<Ordine> getOrdini() {
        return ordini;
    }

    @JsonSetter
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonSetter
    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonSetter
    public void setVia(String via) {
        this.via = via;
    }

    @JsonSetter
    public void setCitta(String citta) {
        this.citta = citta;
    }

    @JsonSetter
    public void setN_civico(String n_civico) {
        this.n_civico = n_civico;
    }

    @JsonSetter
    public void setCap(String cap) {
        this.cap = cap;
    }

    @JsonSetter
    public void setOrdini(List<Ordine> ordini) {
        this.ordini = ordini;
    }

    public void addOrdine(Ordine ordine){
        ordini.add(ordine);
    }
}
