package logistica.rest.request;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import logistica.entities.Fornitore;
import logistica.entities.Fornitura;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FornitoreRequest implements Serializable {
    private Integer id;

    private String name;

    private String via;

    private String citta;

    private String n_civico;

    private String cap;

    private List<Fornitura> forniture = new ArrayList<Fornitura>();

    @JsonGetter
    public Integer getId() {
        return id;
    }

    @JsonGetter
    public String getName() {
        return name;
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
    public List<Fornitura> getForniture() {
        return forniture;
    }

    @JsonSetter
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonSetter
    public void setName(String name) {
        this.name = name;
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
    public void setForniture(List<Fornitura> forniture) {
        this.forniture = forniture;
    }

    public void addFornitura(Fornitura fornitura) {
        this.forniture.add(fornitura);
    }

    public Fornitore translateInOrmObjectForPersist(boolean withRel) {
        if (withRel) {
            return new Fornitore(this.name, this.via, this.citta, this.n_civico, this.cap, this.forniture);
        } else {
            return new Fornitore(this.name, this.via, this.citta, this.n_civico, this.cap);
        }
    }
}
