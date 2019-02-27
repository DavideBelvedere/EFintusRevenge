package logistica.dao;

import logistica.Utility.Em;
import logistica.dao.interfaces.ProdottoDao;
import logistica.entities.Disponibilita;
import logistica.entities.Fornitura;
import logistica.entities.Magazzino;
import logistica.entities.Prodotto2;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;

public class ProdottoDaoImpl implements ProdottoDao {
    @Override
    public Prodotto2 getById(int id) {
        EntityManager em = Em.createEntityManager();
        Prodotto2 prodotto2 = em.find(Prodotto2.class, id);
        Em.closeEntityManager(em);
        return prodotto2;
    }

    @Override
    public HashMap<Magazzino, Character> getProductLocation(int id_prodotto) {
        Prodotto2 prodotto2 = getById(id_prodotto);
        if (prodotto2 != null && prodotto2.getDisponibilita() != null) {
            HashMap<Magazzino, Character> locations = new HashMap<>();
            for (Disponibilita disponibilita : prodotto2.getDisponibilita()) {
                locations.put(disponibilita.getMagazzino(), disponibilita.getSezione());
            }
            if (locations.size() > 0) {
                return locations;
            }
        }
        return null;
    }

    @Override
    public int getProductAvailability(int id_prodotto) {
        Prodotto2 prodotto2 = getById(id_prodotto);
        if (prodotto2 != null && prodotto2.getDisponibilita() != null) {
            int quantita = 0;
            for (Disponibilita disponibilita : prodotto2.getDisponibilita()) {
                quantita += disponibilita.getQuantita();
            }
            return quantita;
        }
        return 0;
    }

    @Override
    public List<Fornitura> getSuppliesOfProduct(int id_prodotto) {
        Prodotto2 prodotto2 = getById(id_prodotto);
        if (prodotto2 != null && prodotto2.getForniture() != null) {
            return prodotto2.getForniture();
        }
        return null;
    }
}
