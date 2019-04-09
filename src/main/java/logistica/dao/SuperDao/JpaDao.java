package logistica.dao.SuperDao;

import logistica.entities.Ordine;
import logistica.entities.superType.Orm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class JpaDao<PO extends Orm, POID> {
    private EntityManagerFactory entityManagerFactory;

    private Class<PO> persistentObjectClass;

    public JpaDao(Class<PO> persistentObjectClass) {
        this.persistentObjectClass = persistentObjectClass;

    }

    protected EntityManager init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("logistica");
        return entityManagerFactory.createEntityManager();
    }

    protected void closeEntityManager(EntityManager em) {
        em.close();
    }

    public void persist(PO objectToPersist) {
        EntityManager em = init();
        em.getTransaction().begin();
        em.persist(objectToPersist);
        em.getTransaction().commit();
        closeEntityManager(em);
    }


    protected PO getByIdUtil(POID id) {
        EntityManager em = init();
        PO po = em.find(persistentObjectClass, id);
        closeEntityManager(em);
        return po;
    }

    protected void deleteByID(POID id) {
        PO poToDelete = getByIdUtil(id);
        EntityManager em = init();
        em.getTransaction().begin();
        em.remove(poToDelete);
        em.getTransaction().commit();
        closeEntityManager(em);

    }

    protected PO getByIdQuery(String queryString, POID id) {
        EntityManager em = init();
        Query query = em.createQuery(queryString);
        query.setParameter("id", id);

        List<PO> results;
        results = query.getResultList();
        PO result;
        if (results.isEmpty()) {
            results = null;
        }
        closeEntityManager(em);

        return results.get(0);
    }

    protected List<PO> getAll(String baseQuery){
        EntityManager em = init();
        List<PO> results;
        Query query = em.createQuery(baseQuery);
        results = query.getResultList();
        if (results.isEmpty()) {
            results = null;
        }
        closeEntityManager(em);

        return results;

    }

}
