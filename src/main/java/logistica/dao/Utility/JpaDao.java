package logistica.dao.Utility;

import logistica.entities.superType.Orm;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaDao<PO extends Orm> {
    /*@PersistenceContext(unitName = "logistica")
    protected EntityManager em;*/
    protected EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("logistica");

}
