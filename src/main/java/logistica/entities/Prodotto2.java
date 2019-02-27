package logistica.entities;

import logistica.entities.superType.Orm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prodotto")
public class Prodotto2 implements Orm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prodotto")
    private int id;

    @OneToMany(mappedBy = "prodotto2", cascade = CascadeType.ALL)
    private List<Fornitura> forniture = new ArrayList<Fornitura>();

    @OneToMany(mappedBy = "primaryKey.prodotto2", cascade = CascadeType.ALL)
    private List<Disponibilita> disponibilita = new ArrayList<Disponibilita>();

    public int getId() {
        return id;
    }

    public Prodotto2() {
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

    @PreRemove
    public void removeFromForniture(){
        for (Fornitura fornitura: forniture) {
            fornitura.setProdotto2(null);
        }
    }
}
