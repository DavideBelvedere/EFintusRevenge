package logistica.dao;

import logistica.Utility.Em;
import logistica.dao.interfaces.PermessoDao;
import logistica.entities.Permesso;

import javax.persistence.EntityManager;

public class PemessoDaoImpl implements PermessoDao {
    @Override
    public Permesso getById(int id) {
        EntityManager em = Em.createEntityManager();
        Permesso permesso = em.find(Permesso.class, id);
        Em.closeEntityManager(em);
        return permesso;
    }
}
