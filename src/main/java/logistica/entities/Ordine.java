package logistica.entities;

import logistica.entities.superType.Orm;

import javax.persistence.*;

@Entity
@Table(name = "ordine")
public class Ordine implements Orm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ordine")
    private Integer id;

    @Column(name = "stato")
    private String stato;
    // one To one and many to one should be always lazy (the other are default lazy)--> eager load automatically
    // the entities relationed for lazy they dug up the values when you effectively call them
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_corriere")
    private Corriere corriere;

    @Column(name = "id_trasporto")
    private Integer id_trasporto;

    public Ordine() {

    }


    public Ordine(String stato, Corriere corriere, Integer id_trasporto) {
        this.stato = stato;
        this.corriere = corriere;
        this.id_trasporto = id_trasporto;
    }

    public Ordine(String stato, Integer id_trasporto) {
        this.stato = stato;
        this.id_trasporto = id_trasporto;
    }

    //constructor for query without relation
    public Ordine(Integer id, String stato, Integer id_trasporto) {
        this.id = id;
        this.stato = stato;
        this.id_trasporto = id_trasporto;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Integer getId() {
        return id;
    }

    public Corriere getCorriere() {
        return corriere;
    }

    public void setCorriere(Corriere corriere) {
        this.corriere = corriere;
    }

    public Integer getId_trasporto() {
        return id_trasporto;
    }

    public void setId_trasporto(Integer id_trasporto) {
        this.id_trasporto = id_trasporto;
    }


}

