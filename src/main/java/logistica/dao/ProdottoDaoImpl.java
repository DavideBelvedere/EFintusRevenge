package logistica.dao;

import logistica.Utility.Em;
import logistica.dao.SuperDao.JpaDao;
import logistica.dao.interfaces.ProdottoDao;
import logistica.entities.Disponibilita;
import logistica.entities.Fornitura;
import logistica.entities.Magazzino;
import logistica.entities.Prodotto;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;

public class ProdottoDaoImpl extends JpaDao<Prodotto, Integer> implements ProdottoDao {
    public ProdottoDaoImpl() {
        super(Prodotto.class);
    }

    private String baseQueryNoRel = "SELECT NEW Prodotto(p.id, p.nome) FROM Prodotto p"; //JOIN FETCH c.ordini

    private String baseQueryWithRel = "SELECT p from Prodotto p JOIN FETCH p.disponibilita";

    @Override
    public Prodotto getById(Integer id, boolean withRel) {
        String queryString;
        if (withRel) {
            queryString = baseQueryWithRel;
        } else {
            queryString = baseQueryNoRel;
        }
        queryString += " WHERE p.id=:id";
        return getByIdQuery(queryString, id);

    }

    @Override
    public HashMap<Magazzino, Character> getProductLocation(Integer id_prodotto) {
        Prodotto prodotto = getById(id_prodotto, true);
        if (prodotto != null && prodotto.getDisponibilita() != null) {
            HashMap<Magazzino, Character> locations = new HashMap<>();
            for (Disponibilita disponibilita : prodotto.getDisponibilita()) {
                locations.put(disponibilita.getMagazzino(), disponibilita.getSezione());
            }
            if (locations.size() > 0) {
                return locations;
            }
        }
        return null;
    }

    @Override
    public Integer getProductAvailability(Integer id_prodotto) {
        Prodotto prodotto = getById(id_prodotto, true);
        if (prodotto != null && prodotto.getDisponibilita() != null) {
            Integer quantita = 0;
            for (Disponibilita disponibilita : prodotto.getDisponibilita()) {
                quantita += disponibilita.getQuantita();
            }
            return quantita;
        }
        return 0;
    }

    @Override
    public List<Fornitura> getSuppliesOfProduct(Integer id_prodotto) {
        Prodotto prodotto = getById(id_prodotto, false);
        if (prodotto != null && prodotto.getForniture() != null) {
            return prodotto.getForniture();
        }
        return null;
    }
}
