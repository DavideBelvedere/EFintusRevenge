package logistica.rest.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import logistica.entities.Magazzino;
import logistica.entities.Prodotto;
import logistica.rest.request.MagazzinoRequest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ProdottoResponse extends ResponsePO<Prodotto> {
    private Integer quantita = null;
    private HashMap<MagazzinoRequest, Character> locazione = new HashMap<>();

    @JsonGetter
    public Integer getQuantita() {
        return quantita;
    }

    @JsonSetter
    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    @JsonGetter
    public HashMap<MagazzinoRequest, Character> getLocazione() {
        return locazione;
    }

    @JsonSetter
    public void setLocazione(HashMap<Magazzino, Character> locazione) {
        locazione= new HashMap<>();
        Iterator it = locazione.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            this.locazione.put(fromOrmTRequest((Magazzino)pair.getKey()),(Character)pair.getValue());
        }
    }

    public void addLocazione(Magazzino magazzino, Character sezione) {
        locazione.put(fromOrmTRequest(magazzino), sezione);
    }

    public MagazzinoRequest fromOrmTRequest(Magazzino m){
        MagazzinoRequest magazzinoRequest = new MagazzinoRequest();
        magazzinoRequest.setAltezza(m.getAltezza());
        magazzinoRequest.setCapacita(m.getCapacita());
        magazzinoRequest.setCap(m.getCap());
        magazzinoRequest.setMetratura(m.getMetratura());
        magazzinoRequest.setN_civico(m.getN_civico());
        magazzinoRequest.setCitta(m.getCitta());
        magazzinoRequest.setLavoratori(m.getLavoratori());
        magazzinoRequest.setId(m.getId());
        magazzinoRequest.setNome(m.getNome());
        magazzinoRequest.setDisponibilita(m.getDisponibilita());
        return magazzinoRequest;
    }

}
