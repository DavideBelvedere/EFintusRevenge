package logistica.entities;

import logistica.entities.key.ProdottoMagazzinoKey;

import javax.persistence.*;

@Entity
@Table(name = "disponibilita")
@AssociationOverrides({//to override the mappings for the prodotto and fornitore attributes of the composite key.
        @AssociationOverride(name = "primaryKey.magazzino",
                joinColumns = @JoinColumn(name = "id_magazzino")),
        @AssociationOverride(name = "primaryKey.prodotto2",
                joinColumns = @JoinColumn(name = "id_prodotto"))})
public class Disponibilita {
    @EmbeddedId
    private ProdottoMagazzinoKey primaryKey = new ProdottoMagazzinoKey();

    @Column(name = "quantita")
    private int quantita;

    @Column(name="sezione_magazzino", length = 1)
    private char sezione;

    @Transient
    public Prodotto2 getProdotto(){
        return primaryKey.getProdotto2();
    }

    public void setProdotto(Prodotto2 prodotto2){
        primaryKey.setProdotto2(prodotto2);
    }


    public Disponibilita(){ }

    public Disponibilita(ProdottoMagazzinoKey primaryKey, int quantita, char sezione) {
        this.primaryKey = primaryKey;
        this.quantita = quantita;
        this.sezione = sezione;
    }

    @Transient
    public  Magazzino getMagazzino(){
        return  primaryKey.getMagazzino();
    }

    public void setMagazzino(Magazzino magazzino){
        primaryKey.setMagazzino(magazzino);
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public char getSezione() {
        return sezione;
    }

    public void setSezione(char sezione) {
        this.sezione = sezione;
    }

    public ProdottoMagazzinoKey getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(ProdottoMagazzinoKey primaryKey) {
        this.primaryKey = primaryKey;
    }
}
