package logistica.rest.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import logistica.entities.Magazzino;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MagazzinoResponse implements Serializable {
    private List<Magazzino> magazzini = new ArrayList<>();

    @JsonGetter
    public List<Magazzino> getMagazzini() {
        return magazzini;
    }

    @JsonSetter
    public void setMagazzini(List<Magazzino> magazzini) {
        this.magazzini = magazzini;
    }

    public void addMagazzini(Magazzino magazzino) {
        magazzini.add(magazzino);
    }
}
