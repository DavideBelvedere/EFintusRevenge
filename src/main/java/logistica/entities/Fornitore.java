package logistica.entities;

import logistica.entities.superType.Orm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fornitore")
public class Fornitore implements Orm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornitore")
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "via", length = 100)
    private String via;

    @Column(name = "citta", length = 100)
    private String citta;

    @Column(name = "n_civico", length = 10)
    private String n_civico;

    @Column(name = "cap", length = 6)
    private String cap;

    @OneToMany(mappedBy = "fornitore", cascade = CascadeType.ALL)
    private List<Fornitura> forniture = new ArrayList<Fornitura>();

    public Fornitore() {
    }

    public Fornitore(String name, String via, String citta, String n_civico, String cap, List<Fornitura> forniture) {
        this.name = name;
        this.via = via;
        this.citta = citta;
        this.n_civico = n_civico;
        this.cap = cap;
        this.forniture = forniture;
    }

    public Fornitore(String name, String via, String citta, String n_civico, String cap) {
        this.name = name;
        this.via = via;
        this.citta = citta;
        this.n_civico = n_civico;
        this.cap = cap;
    }

    //constructor for query without relation
    public Fornitore(Integer id, String name, String via, String citta, String n_civico, String cap) {
        this.id = id;
        this.name = name;
        this.via = via;
        this.citta = citta;
        this.n_civico = n_civico;
        this.cap = cap;
    }

    public Fornitore(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }


    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public List<Fornitura> getForniture() {
        return forniture;
    }

    public void setForniture(List<Fornitura> forniture) {
        this.forniture = forniture;
    }

    public void addFornitura(Fornitura f) {
        forniture.add(f);
    }

    @PreRemove
    public void removeFromForniture() {
        for (Fornitura fornitura : forniture) {
            fornitura.setFornitore(null);
        }
    }
}
