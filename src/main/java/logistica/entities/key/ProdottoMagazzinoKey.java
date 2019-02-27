package logistica.entities.key;

import logistica.entities.Magazzino;
import logistica.entities.Prodotto2;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ProdottoMagazzinoKey implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    private Magazzino magazzino;

    @ManyToOne(cascade = CascadeType.ALL)
    private Prodotto2 prodotto2;

    public Magazzino getMagazzino() {
        return magazzino;
    }

    public void setMagazzino(Magazzino magazzino) {
        this.magazzino = magazzino;
    }

    public Prodotto2 getProdotto2() {
        return prodotto2;
    }

    public void setProdotto2(Prodotto2 prodotto2) {
        this.prodotto2 = prodotto2;
    }
}
