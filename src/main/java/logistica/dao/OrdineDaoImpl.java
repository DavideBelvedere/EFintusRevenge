package logistica.dao;


import logistica.Utility.CRUDUtil;
import logistica.dao.interfaces.OrdineDao;
import logistica.entities.Corriere;
import logistica.entities.Ordine;

public class OrdineDaoImpl implements OrdineDao {

    @Override
    public boolean saveOrdine(Ordine ordine, boolean withRel) {
        if (!withRel) {
            ordine.setCorriere(null);
        }
        return CRUDUtil.save(ordine);
    }

    @Override
    public boolean updateOrdine(Ordine ordine) {
        return false;
    }

    @Override
    public boolean deleteOrdine(int id_ordine) {
        return false;
    }

    @Override
    public Ordine getById(int id_ordine) {
        return CRUDUtil.getById(id_ordine, Ordine.class,true);
    }

    @Override
    public Corriere getCourierOfOrder(int id_ordine) {
        Ordine ordine = getById(id_ordine);
        if (ordine != null) {
            return ordine.getCorriere();
        }
        return null;
    }
}
