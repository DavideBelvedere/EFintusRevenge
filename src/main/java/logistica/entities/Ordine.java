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

    // one To one and many to one should be always lazy (the other are default lazy)--> eager load automatically
    // the entities relationed for lazy they dug up the values when you effectively call them
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="id_corriere")

    private Corriere corriere;

    @Column(name = "id_trasporto")
    private Integer id_trasporto;

    public Ordine(){

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

