package logistica.dao;

import logistica.Utility.CRUDUtil;
import logistica.Utility.Em;
import logistica.dao.interfaces.CorriereDao;
import logistica.entities.Corriere;

import javax.persistence.EntityManager;

public class CorriereDaoImpl implements CorriereDao {
    @Override
    public boolean saveCorriere(Corriere corriere) {
        return CRUDUtil.save(corriere);
    }

    @Override
    public boolean updateCorriere(Corriere corriere) {
        return saveCorriere(corriere);
    }

    @Override
    public boolean deleteCorriere(int id_corriere) {
        EntityManager em = Em.createEntityManager();
        try {
            Corriere corriere = getById(id_corriere, false);

            em.getTransaction().begin();
            em.remove(corriere);
            Em.closeEntityManager(em);

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Errore: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Corriere getById(int id_corriere, boolean withRel) {
        return CRUDUtil.getById(id_corriere, Corriere.class, withRel);

    }
}
