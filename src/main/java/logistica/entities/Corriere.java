package logistica.entities;

import logistica.entities.superType.Orm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "corriere")
public class Corriere implements Orm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_corriere")
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "via", length = 100)
    private String via;

    @Column(name = "citta", length = 100)
    private String citta;

    @Column(name = "n_civico", length = 10)
    private String n_civico;

    @Column(name = "cap", length = 6)
    private String cap;

    @OneToMany(mappedBy = "corriere")
    private List<Ordine> ordini = new ArrayList<>();

    public Corriere() {
    }

    public Corriere(String nome, String via, String citta, String n_civico, String cap, List<Ordine> ordini) {
        this.nome = nome;
        this.via = via;
        this.citta = citta;
        this.n_civico = n_civico;
        this.cap = cap;
        this.ordini = ordini;
    }

    public Corriere(String nome, String via, String citta, String n_civico, String cap) {
        this.via = via;
        this.citta = citta;
        this.n_civico = n_civico;
        this.cap = cap;

    }

    //constructor for query without relation
    public Corriere(Integer id, String nome, String via, String citta, String n_civico, String cap) {
        this.id = id;
        this.nome = nome;
        this.via = via;
        this.citta = citta;
        this.n_civico = n_civico;
        this.cap = cap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Ordine> getOrdini() {
        return ordini;
    }


    //fa l'on delete set null
    @PreRemove
    public void removeForeignKey() {
        for (Ordine ordine : ordini) {
            ordine.setCorriere(null);
        }
    }

    @Override
    public String toString() {
        return "Corriere{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", via='" + via + '\'' +
                ", citta='" + citta + '\'' +
                ", n_civico='" + n_civico + '\'' +
                ", cap='" + cap + '\'' +
                '}';
    }
}