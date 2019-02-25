package logistica.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fornitura")

public class Fornitura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_fornitura")
    private Integer id;

    @Column(name = "quantita")
    private Integer quantita;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prodotto")
    private Prodotto prodotto;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fornitore")
    private Fornitore fornitore;

    public Fornitura(){ }

    public Fornitura( Integer quantita, Date date) {
        this.quantita = quantita;
        this.date = date;
    }



    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public Fornitore getFornitore() {
        return fornitore;
    }

    public void setFornitore(Fornitore fornitore) {
        this.fornitore = fornitore;
    }
}
