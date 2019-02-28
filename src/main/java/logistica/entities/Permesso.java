package logistica.entities;

import logistica.entities.superType.Orm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "permesso")
public class Permesso implements Orm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permesso")
    private Integer id;

    @Column(name = "tipo", length = 20)
    private String tipo;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinTable(name = "lavoratore_permesso",
            joinColumns = @JoinColumn(name = "id_permesso"),
            inverseJoinColumns = @JoinColumn(name = "codice_fiscale")
    )
    private List<Lavoratore> lavoratori = new ArrayList<Lavoratore>();

    public Permesso() {
    }

    public Permesso(String tipo) {
        this.tipo = tipo;
    }

    public Permesso(String tipo, List<Lavoratore> lavoratori) {
        this.tipo = tipo;
        this.lavoratori = lavoratori;
    }

    //constructor for query without relation
    public Permesso(Integer id, String tipo) {
        this.tipo = tipo;
    }


    public Integer getId() {
        return id;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Lavoratore> getLavoratori() {
        return lavoratori;
    }

    public void setLavoratori(List<Lavoratore> lavoratori) {
        this.lavoratori = lavoratori;
    }
}
