package logistica.rest.request;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import logistica.entities.Lavoratore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PermessoRequest implements Serializable {
    private Integer id;

    private String tipo;

    private List<Lavoratore> lavoratori = new ArrayList<>();

    @JsonGetter
    public Integer getId() {
        return id;
    }

    @JsonSetter
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonGetter
    public String getTipo() {
        return tipo;
    }

    @JsonSetter
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonGetter
    public List<Lavoratore> getLavoratori() {
        return lavoratori;
    }

    @JsonSetter
    public void setLavoratori(List<Lavoratore> lavoratori) {
        this.lavoratori = lavoratori;
    }

    public void addLavoratore(Lavoratore lavoratore) {
        this.lavoratori.add(lavoratore);
    }
}
