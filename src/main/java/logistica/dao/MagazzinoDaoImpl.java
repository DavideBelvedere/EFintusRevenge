package logistica.dao;

import logistica.dao.Utility.JpaDao;
import logistica.dao.interfaces.MagazzinoDao;
import logistica.entities.Disponibilita;
import logistica.entities.Lavoratore;
import logistica.entities.Magazzino;
import logistica.entities.Prodotto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class MagazzinoDaoImpl extends JpaDao<Magazzino, Integer> implements MagazzinoDao {

    private String baseQueryNoRel = "SELECT NEW Magazzino(m.id,m.via,m.citta,m.n_civico,m.cap,m.metratura,m.altezza,m.capacita) FROM Magazzino m"; //JOIN FETCH c.ordini

    public MagazzinoDaoImpl() {
        super(Magazzino.class);
    }


    @Override
    public Magazzino getById(Integer id, boolean withrel) {
        EntityManager em = init();
        String queryString = baseQueryNoRel;
        if (withrel) {
            queryString += " JOIN FETCH m.lavoratori, m.disponibilita";
        }
        queryString += " WHERE m.id=:id";

        Query query = em.createQuery(queryString);
        query.setParameter("id", id);

        List<Magazzino> results;
        results = query.getResultList();
        Magazzino result;
        if (results.isEmpty()) {
            results = null;
        }

        return results.get(0);


    }

    @Override
    public List<Prodotto> getAllProductInWarehouse(Integer id_magazzino) {
        Magazzino magazzino = getByIdUtil(id_magazzino);
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
        Magazzino magazzino = getByIdUtil(id_magazzino);
        if (magazzino != null && magazzino.getLavoratori() != null) {
            return magazzino.getLavoratori();
        }
        return null;
    }

    @Override
    public List<Magazzino> getAllWarehouse() {
        EntityManager em = init();
        List<Magazzino> results;
        Query query = em.createQuery(baseQueryNoRel);
        results = query.getResultList();
        if (results.isEmpty()) {
            results = null;
        }

        return results;
    }


}
