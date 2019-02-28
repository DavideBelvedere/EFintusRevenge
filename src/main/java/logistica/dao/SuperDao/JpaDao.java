package logistica.dao.SuperDao;

import logistica.entities.superType.Orm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        entityManagerFactory.close();
    }

    protected void persist(PO objectToPersist) {
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

}
