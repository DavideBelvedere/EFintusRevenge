package logistica.dao.interfaces;

import logistica.entities.Corriere;
import logistica.entities.Ordine;

import java.util.List;

public interface OrdineDao {

    /***
     * Write on db an ordine object with or without the corresponding courier
     * @param ordine is the object to write on db
     * @param withRel with a true value also the courier is writed on db, with false the relation is not writed
     * @return true if the save is gone fine, in case of exception return false
     */
    void saveOrdine(Ordine ordine, boolean withRel);

    void updateOrdine(Ordine ordine);

    void deleteOrdine(Integer id_ordine);

    Ordine getById(Integer id_ordine, boolean withRel);

    Corriere getCourierOfOrder(Integer id_ordine);

    List<Ordine> getAllOrders();
}
