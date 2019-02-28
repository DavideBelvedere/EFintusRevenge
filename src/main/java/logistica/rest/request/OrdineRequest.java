package logistica.rest.request;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import logistica.entities.Corriere;

import java.io.Serializable;

public class OrdineRequest implements Serializable {

    private Integer id;

    private Corriere corriere;

    private Integer id_trasporto;

    private String stato;

    @JsonGetter
    public Integer getId() {
        return id;
    }

    @JsonSetter
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonGetter
    public Corriere getCorriere() {
        return corriere;
    }


    @JsonSetter
    public void setCorriere(Corriere corriere) {
        this.corriere = corriere;
    }

    @JsonGetter
    public Integer getId_trasporto() {
        return id_trasporto;
    }


    @JsonSetter
    public void setId_trasporto(Integer id_trasporto) {
        this.id_trasporto = id_trasporto;
    }

    @JsonGetter
    public String getStato() {
        return stato;
    }

    @JsonSetter
    public void setStato(String stato) {
        this.stato = stato;
    }
}
