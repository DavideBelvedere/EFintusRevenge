package logistica.rest.request;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import logistica.entities.Disponibilita;
import logistica.entities.Fornitura;
import logistica.entities.Prodotto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProdottoRequest implements Serializable {
    private Integer id;

    private String nome;

    private List<Fornitura> forniture = new ArrayList<Fornitura>();

    private List<Disponibilita> disponibilita = new ArrayList<Disponibilita>();

    @JsonGetter
    public Integer getId() {
        return id;
    }

    @JsonSetter
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonGetter
    public String getNome() {
        return nome;
    }

    @JsonSetter
    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonGetter
    public List<Fornitura> getForniture() {
        return forniture;
    }

    @JsonSetter
    public void setForniture(List<Fornitura> forniture) {
        this.forniture = forniture;
    }

    @JsonGetter
    public List<Disponibilita> getDisponibilita() {
        return disponibilita;
    }

    @JsonSetter
    public void setDisponibilita(List<Disponibilita> disponibilita) {
        this.disponibilita = disponibilita;
    }

    public Prodotto translateInOrmObjectForPersist(boolean withRel) {
        if(withRel){
            return new Prodotto(this.nome,this.forniture, this.disponibilita);
        }else {
            return new Prodotto(this.nome);
        }
    }


}
