package logistica.dao.interfaces;

import logistica.entities.Corriere;
import logistica.entities.Ordine2;

public interface OrdineDao {

    /***
     * Write on db an ordine2 object with or without the corresponding courier
     * @param ordine2 is the object to write on db
     * @param withRel with a true value also the courier is writed on db, with false the relation is not writed
     * @return true if the save is gone fine, in case of exception return false
     */
    boolean saveOrdine(Ordine2 ordine2, boolean withRel);

    boolean updateOrdine(Ordine2 ordine2);

    boolean deleteOrdine(int id_ordine);

    Ordine2 getById(int id_ordine);

    Corriere getCourierOfOrder(int id_ordine);
}
