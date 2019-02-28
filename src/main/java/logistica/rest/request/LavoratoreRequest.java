package logistica.rest.request;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import logistica.entities.Magazzino;
import logistica.entities.Permesso;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class LavoratoreRequest implements Serializable {

    private String codice_fiscale;

    private String nome;

    private String cognome;

    private String via;

    private String citta;

    private String n_civico;

    private String cap;

    private Date data_nascita;

    private Magazzino magazzino;

    private List<Permesso> permessoList;


    @JsonGetter
    public String getCodice_fiscale() {
        return codice_fiscale;
    }

    public void setCodice_fiscale(String codice_fiscale) {
        this.codice_fiscale = codice_fiscale;
    }

    @JsonGetter
    public String getNome() {
        return nome;
    }

    @JsonSetter
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    @JsonGetter
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getVia() {
        return via;
    }

    @JsonGetter
    public void setVia(String via) {
        this.via = via;
    }

    @JsonSetter
    public String getCitta() {
        return citta;
    }

    @JsonSetter
    public void setCitta(String citta) {
        this.citta = citta;
    }

    @JsonGetter
    public String getN_civico() {
        return n_civico;
    }

    @JsonSetter
    public void setN_civico(String n_civico) {
        this.n_civico = n_civico;
    }

    @JsonGetter
    public String getCap() {
        return cap;
    }

    @JsonSetter
    public void setCap(String cap) {
        this.cap = cap;
    }

    @JsonGetter
    public Date getData_nascita() {
        return data_nascita;
    }

    @JsonSetter
    public void setData_nascita(Date data_nascita) {
        this.data_nascita = data_nascita;
    }

    @JsonGetter
    public Magazzino getMagazzino() {
        return magazzino;
    }

    @JsonSetter
    public void setMagazzino(Magazzino magazzino) {
        this.magazzino = magazzino;
    }

    @JsonGetter
    public List<Permesso> getPermessoList() {
        return permessoList;
    }

    @JsonSetter
    public void setPermessoList(List<Permesso> permessoList) {
        this.permessoList = permessoList;
    }

    public  void addPermess(Permesso permesso){
        this.permessoList.add(permesso);
    }
}
