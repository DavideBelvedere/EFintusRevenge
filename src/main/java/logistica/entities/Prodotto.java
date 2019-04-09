package logistica.entities;

import logistica.entities.superType.Orm;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prodotto")
public class Prodotto implements Orm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prodotto")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "prodotto", cascade = CascadeType.ALL)
    private List<Fornitura> forniture = new ArrayList<Fornitura>();

    @JsonIgnore
    @OneToMany(mappedBy = "primaryKey.prodotto", cascade = CascadeType.ALL)
    private List<Disponibilita> disponibilita = new ArrayList<Disponibilita>();

    public Integer getId() {
        return id;
    }

    public Prodotto() {
    }

    public Prodotto(String nome) {
        this.nome = nome;
    }

    //constructor for query without relation
    public Prodotto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Prodotto(String nome, List<Fornitura> forniture, List<Disponibilita> disponibilita) {
        this.nome = nome;
        this.forniture = forniture;
        this.disponibilita = disponibilita;
    }


    public List<Fornitura> getForniture() {
        return forniture;
    }

    public void setForniture(List<Fornitura> forniture) {
        this.forniture = forniture;
    }

    public void addFornitura(Fornitura fornitura) {
        this.forniture.add(fornitura);
    }

    public List<Disponibilita> getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(List<Disponibilita> disponibilita) {
        this.disponibilita = disponibilita;
    }

    public void addDisponibilita(Disponibilita disponibilita) {
        this.disponibilita.add(disponibilita);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    @PreRemove
    public void removeFromForniture() {
        for (Fornitura fornitura : forniture) {
            fornitura.setProdotto(null);
        }
    }
}
