package logistica.entities;

import logistica.entities.superType.Orm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "magazzino")
public class Magazzino implements Orm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_magazzino")
    private Integer id;

    @Column(name = "via", length = 100)
    private String via;

    @Column(name= "nome")
    private String nome;

    @Column(name = "citta", length = 100)
    private String citta;

    @Column(name = "n_civico", length = 10)
    private String n_civico;

    @Column(name = "cap", length = 6)
    private String cap;

    @Column(name = "metratura")
    private Double metratura;

    @Column(name = "altezza")
    private Double altezza;

    @Column(name = "capacita")
    private Double capacita;

    @OneToMany(mappedBy = "magazzino", fetch = FetchType.LAZY)
    private List<Lavoratore> lavoratori = new ArrayList<Lavoratore>();

    @OneToMany(mappedBy = "primaryKey.magazzino", cascade = CascadeType.ALL)
    private List<Disponibilita> disponibilita = new ArrayList<Disponibilita>();

    public Magazzino(){}

    public Magazzino(String via, String nome, String citta, String n_civico, String cap, Double metratura, Double altezza, Double capacita, List<Lavoratore> lavoratori, List<Disponibilita> disponibilita) {
        this.via = via;
        this.nome = nome;
        this.citta = citta;
        this.n_civico = n_civico;
        this.cap = cap;
        this.metratura = metratura;
        this.altezza = altezza;
        this.capacita = capacita;
        this.lavoratori = lavoratori;
        this.disponibilita = disponibilita;
    }

    public Magazzino(String via, String nome, String citta, String n_civico, String cap, Double metratura, Double altezza, Double capacita) {
        this.via = via;
        this.nome = nome;
        this.citta = citta;
        this.n_civico = n_civico;
        this.cap = cap;
        this.metratura = metratura;
        this.altezza = altezza;
        this.capacita = capacita;
    }

    //constructor for query without relation
    public Magazzino(Integer id, String via, String citta, String n_civico, String cap, Double metratura, Double altezza, Double capacita, String nome) {
        this.nome= nome;
        this.id = id;
        this.via = via;
        this.citta = citta;
        this.n_civico = n_civico;
        this.cap = cap;
        this.metratura = metratura;
        this.altezza = altezza;
        this.capacita = capacita;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getN_civico() {
        return n_civico;
    }

    public void setN_civico(String n_civico) {
        this.n_civico = n_civico;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public Double getMetratura() {
        return metratura;
    }

    public void setMetratura(Double metratura) {
        this.metratura = metratura;
    }

    public Double getAltezza() {
        return altezza;
    }

    public void setAltezza(Double altezza) {
        this.altezza = altezza;
    }

    public Double getCapacita() {
        return capacita;
    }

    public void setCapacita(Double capacita) {
        this.capacita = capacita;
    }

    public List<Lavoratore> getLavoratori() {
        return lavoratori;
    }

    public void setLavoratori(List<Lavoratore> lavoratori) {
        this.lavoratori = lavoratori;
    }

    public List<Disponibilita> getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(List<Disponibilita> disponibilita) {
        this.disponibilita = disponibilita;
    }

    @PreRemove
    private void removeForeignKey() {
        for (Lavoratore lavoratore : lavoratori) {
            lavoratore.setMagazzino(null);
        }
    }
}
