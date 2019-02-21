package logistica.dao;

import logistica.Utility.Em;
import logistica.dao.interfaces.LavoratoreDao;
import logistica.entities.Lavoratore;
import logistica.entities.Magazzino;
import logistica.entities.Permesso;

import javax.persistence.EntityManager;
import java.util.List;

public class LavoratoreDaoImpl implements LavoratoreDao {
    @Override
    public Lavoratore getById(String codice_fiscale) {
        EntityManager em = Em.createEntityManager();
        Lavoratore lavoratore = em.find(Lavoratore.class, codice_fiscale);
        Em.closeEntityManager(em);
        return lavoratore;
    }

    @Override
    public Magazzino getWorkerWarehouse(String codice_fiscale) {
        Lavoratore lavoratore = getById(codice_fiscale);
        if (lavoratore != null) {
            return lavoratore.getMagazzino();
        }
        return null;
    }

    @Override
    public List<Permesso> getWorkerAuthorization(String codice_fiscale) {
        Lavoratore lavoratore = getById(codice_fiscale);
        if(lavoratore != null){
            return lavoratore.getPermessi();
        }
        return null;
    }
}
