package logistica.dao;


import logistica.Utility.CRUDUtil;
import logistica.dao.interfaces.OrdineDao;
import logistica.entities.Corriere;
import logistica.entities.Ordine2;

public class OrdineDaoImpl implements OrdineDao {

    @Override
    public boolean saveOrdine(Ordine2 ordine2, boolean withRel) {
        if (!withRel) {
            ordine2.setCorriere(null);
        }
        return CRUDUtil.save(ordine2);
    }

    @Override
    public boolean updateOrdine(Ordine2 ordine2) {
        return false;
    }

    @Override
    public boolean deleteOrdine(int id_ordine) {
        return false;
    }

    @Override
    public Ordine2 getById(int id_ordine) {
        return CRUDUtil.getById(id_ordine, Ordine2.class,true);
    }

    @Override
    public Corriere getCourierOfOrder(int id_ordine) {
        Ordine2 ordine2 = getById(id_ordine);
        if (ordine2 != null) {
            return ordine2.getCorriere();
        }
        return null;
    }
}
