package logistica.rest.request;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import logistica.entities.Disponibilita;
import logistica.entities.Lavoratore;
import logistica.entities.superType.Orm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MagazzinoRequest implements Serializable {

    private int id;

    private String via;

    private String citta;

    private String n_civico;

    private String cap;

    private double metratura;

    private double altezza;

    private double capacita;

    private List<Lavoratore> lavoratori = new ArrayList<>();

    private List<Disponibilita> disponibilita = new ArrayList<>();

    @JsonGetter
    public int getId() {
        return id;
    }

    @JsonSetter
    public void setId(int id) {
        this.id = id;
    }

    @JsonGetter
    public String getVia() {
        return via;
    }

    @JsonSetter
    public void setVia(String via) {
        this.via = via;
    }

    @JsonGetter
    public String getCitta() {
        return citta;
    }

    @JsonSetter
    public void setCitta(String citta) {
        this.citta = citta;
    }

    @JsonGetter
    public String getN_civico() {
        return n_civico;
    }

    @JsonSetter
    public void setN_civico(String n_civico) {
        this.n_civico = n_civico;
    }

    @JsonGetter
    public String getCap() {
        return cap;
    }

    @JsonSetter
    public void setCap(String cap) {
        this.cap = cap;
    }

    @JsonGetter
    public double getMetratura() {
        return metratura;
    }

    @JsonSetter
    public void setMetratura(double metratura) {
        this.metratura = metratura;
    }

    @JsonGetter
    public double getAltezza() {
        return altezza;
    }

    @JsonSetter
    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    @JsonGetter
    public double getCapacita() {
        return capacita;
    }

    @JsonSetter
    public void setCapacita(double capacita) {
        this.capacita = capacita;
    }

    @JsonGetter
    public List<Lavoratore> getLavoratori() {
        return lavoratori;
    }

    @JsonSetter
    public void setLavoratori(List<Lavoratore> lavoratori) {
        this.lavoratori = lavoratori;
    }

    public void addLavoratore(Lavoratore lavoratore) {
        this.lavoratori.add(lavoratore);
    }

    @JsonGetter
    public List<Disponibilita> getDisponibilita() {
        return disponibilita;
    }

    @JsonSetter
    public void setDisponibilita(List<Disponibilita> disponibilita) {
        this.disponibilita = disponibilita;
    }

    public void addDisponibilita(Disponibilita disponibilita) {
        this.disponibilita.add(disponibilita);
    }
}
