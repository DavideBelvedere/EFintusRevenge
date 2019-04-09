package logistica.dao;


import logistica.dao.SuperDao.JpaDao;
import logistica.dao.interfaces.OrdineDao;
import logistica.entities.Corriere;
import logistica.entities.Magazzino;
import logistica.entities.Ordine;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class OrdineDaoImpl extends JpaDao<Ordine, Integer> implements OrdineDao {

    private String baseQueryNoRel = "SELECT NEW Ordine(o.id,o.stato,o.id_trasporto) FROM Ordine o";

    private String baseQueryWithRel = "SELECT o from Ordine o JOIN FETCH o.corriere";

    public OrdineDaoImpl() {
        super(Ordine.class);
    }

    @Override
    public void saveOrdine(Ordine ordine, boolean withRel) {
        if (!withRel) {
            ordine.setCorriere(null);
        }
        persist(ordine);
    }

    @Override
    public void updateOrdine(Ordine ordine) {

    }

    @Override
    public void deleteOrdine(Integer id_ordine) {

    }

    @Override
    public Ordine getById(Integer id, boolean withrel) {

        String queryString;
        if (withrel) {
            queryString = baseQueryWithRel;
        } else {
            queryString = baseQueryNoRel;
        }
        queryString += " WHERE o.id=:id";

        return getByIdQuery(queryString, id);


    }

    @Override
    public List<Ordine> getAllOrders() {
        return getAll(baseQueryNoRel);
    }


    @Override
    public Corriere getCourierOfOrder(Integer id_ordine) {
        Ordine ordine = getById(id_ordine, true);
        if (ordine != null) {
            return ordine.getCorriere();
        }
        return null;
    }
}
