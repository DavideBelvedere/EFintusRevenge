package logistica.dao.interfaces;

import logistica.entities.Corriere;
import logistica.entities.Ordine;

public interface OrdineDao {

    /***
     * Write on db an ordine object with or without the corresponding courier
     * @param ordine is the object to write on db
     * @param withRel with a true value also the courier is writed on db, with false the relation is not writed
     * @return true if the save is gone fine, in case of exception return false
     */
    boolean saveOrdine(Ordine ordine, boolean withRel);

    boolean updateOrdine(Ordine ordine);

    boolean deleteOrdine(Integer id_ordine);

    Ordine getById(Integer id_ordine);

    Corriere getCourierOfOrder(Integer id_ordine);
}
