package logistica.dao;

import logistica.Utility.Em;
import logistica.dao.Utility.JpaDao;
import logistica.dao.interfaces.MagazzinoDao;
import logistica.entities.Disponibilita;
import logistica.entities.Lavoratore;
import logistica.entities.Magazzino;
import logistica.entities.Prodotto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class MagazzinoDaoImpl extends JpaDao<Magazzino> implements MagazzinoDao {

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
        //EntityManager em = Em.createEntityManager();
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Magazzino> results;
        try {
            Query query = em.createQuery("SELECT m FROM Magazzino m");
            results = query.getResultList();
            if (results.isEmpty()) {
                results = null;
            }
            for (Magazzino m:
                 results) {
                m.setLavoratori(null);
                m.setDisponibilita(null);

            }
            em.close();
            // Em.closeEntityManager(em);
        } catch (Exception e){
            results = new ArrayList<Magazzino>();
            Magazzino m = new Magazzino();
            m.setCap("20861");
            m.setCitta("roma");
            results.add(m);
        }
        return results;
    }


}
