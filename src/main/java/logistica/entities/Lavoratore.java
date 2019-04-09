package logistica.entities;


import logistica.entities.superType.Orm;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lavoratore")
public class Lavoratore implements Orm {
    @Id
    @Column(name = "codice_fiscale", length = 100)
    private String id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cognome", length = 100)
    private String cognome;

    @Column(name = "via", length = 100)
    private String via;

    @Column(name = "citta", length = 100)
    private String citta;

    @Column(name = "n_civico", length = 10)
    private String n_civico;

    @Column(name = "cap", length = 6)
    private String cap;


    @Column(name = "data_nascita")
    @Temporal(TemporalType.DATE)
    private Date data_nascita;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_magazzino")
    @JsonIgnore
    private Magazzino magazzino;

    // @ManyToMany(mappedBy = "lavoratori") //non permette di inserire i prodotti e la relazione persistendo l'entità lavoratore
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinTable(name = "lavoratore_permesso",
            joinColumns = @JoinColumn(name = "codice_fiscale"),
            inverseJoinColumns = @JoinColumn(name = "id_permesso")
    )
    @JsonIgnore
    private List<Permesso> permessi = new ArrayList<Permesso>();

    public Lavoratore() {
    }

    public Lavoratore(String id, String nome, String cognome, String via, String citta, String n_civico, String cap, Date data_nascita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.via = via;
        this.citta = citta;
        this.n_civico = n_civico;
        this.cap = cap;
        this.data_nascita = data_nascita;
    }

    public Lavoratore(String id, String nome, String cognome, String via, String citta, String n_civico, String cap, Date data_nascita, Magazzino magazzino, List<Permesso> permessi) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.via = via;
        this.citta = citta;
        this.n_civico = n_civico;
        this.cap = cap;
        this.data_nascita = data_nascita;
        this.magazzino = magazzino;
        this.permessi = permessi;
    }

    public String getId() {
        return id;
    }

    public void setId(String cf) {
        id = cf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public List<Permesso> getPermessi() {
        return permessi;
    }

    public void setPermessi(List<Permesso> permessi) {
        this.permessi = permessi;
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

    public Magazzino getMagazzino() {
        return magazzino;
    }

    public void setMagazzino(Magazzino magazzino) {
        this.magazzino = magazzino;
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

    public Date getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(Date data_nascita) {
        this.data_nascita = data_nascita;
    }
}
