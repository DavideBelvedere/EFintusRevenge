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
    private int id;

    @Column(name = "via", length = 100)
    private String via;

    @Column(name = "citta", length = 100)
    private String citta;

    @Column(name = "n_civico", length = 10)
    private String n_civico;

    @Column(name = "cap", length = 6)
    private String cap;

    @Column(name = "metratura")
    private double metratura;

    @Column(name = "altezza")
    private double altezza;

    @Column(name = "capacita")
    private double capacita;

    @OneToMany(mappedBy = "magazzino", fetch = FetchType.LAZY)
    private List<Lavoratore> lavoratori= new ArrayList<Lavoratore>();

    @OneToMany(mappedBy = "primaryKey.magazzino", cascade = CascadeType.ALL)
    private List<Disponibilita> disponibilita =new ArrayList<Disponibilita>();

    public Magazzino() {
    }

    public Magazzino(String via, String citta, String n_civico, String cap, double metratura, double altezza, double capacita) {
        this.via = via;
        this.citta = citta;
        this.n_civico = n_civico;
        this.cap = cap;
        this.metratura = metratura;
        this.altezza = altezza;
        this.capacita = capacita;
    }

    public int getId() {
        return id;
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

    public double getMetratura() {
        return metratura;
    }

    public void setMetratura(double metratura) {
        this.metratura = metratura;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public double getCapacita() {
        return capacita;
    }

    public void setCapacita(double capacita) {
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
