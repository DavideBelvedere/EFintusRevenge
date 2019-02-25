package logistica.dao;

import logistica.Utility.Em;
import logistica.dao.interfaces.MagazzinoDao;
import logistica.entities.Disponibilita;
import logistica.entities.Lavoratore;
import logistica.entities.Magazzino;
import logistica.entities.Prodotto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class MagazzinoDaoImpl implements MagazzinoDao {
    @Override
    public Magazzino getById(Integer id) {
        EntityManager em = Em.createEntityManager();
        Magazzino magazzino = em.find(Magazzino.class, id);
        Em.closeEntityManager(em);
        return magazzino;
    }

    @Override
    public List<Prodotto> getAllProductInWarehouse(Integer id_magazzino) {
        Magazzino magazzino = getById(id_magazzino);
        if (magazzino != null && magazzino.getDisponibilita() != null) {
            List<Prodotto> prodotti = new ArrayList<>();
            for (Disponibilita disponibilita : magazzino.getDisponibilita()) {
                if (disponibilita.getProdotto() != null) {
                    prodotti.add(disponibilita.getProdotto());
                }
            }
            if (prodotti.size() > 0) {
                return prodotti;
            }

        }
        return null;
    }


    @Override
    public List<Lavoratore> getAllWorkersInWarehouse(Integer id_magazzino) {
        Magazzino magazzino = getById(id_magazzino);
        if (magazzino != null && magazzino.getLavoratori() != null) {
            return magazzino.getLavoratori();
        }
        return null;
    }

    @Override
    public List<Magazzino> getAllWarehouse() {
        EntityManager em = Em.createEntityManager();
        Query query = em.createQuery("SELECT m FROM Magazzino m");
        List results = query.getResultList();
        if (results.isEmpty()) {
            results = null;
        }
        Em.closeEntityManager(em);
        return results;
    }


}
