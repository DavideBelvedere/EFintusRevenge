package com.lynx.EFintus.commercio.dao;

import javax.persistence.EntityManager;

import com.lynx.EFintus.commercio.classes.persistable.Persistable;
import com.lynx.EFintus.commercio.interfaces.Dao;
import com.lynx.EFintus.commercio.utility.Em;
import org.hibernate.Session;

public abstract class GenericDao<T> implements Dao<T> {

    public static Persistable persistableSave(Persistable object) {
		EntityManager em = Em.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(object);
			Em.closeEntityManager(em);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore: " + e.getMessage());
			return null;
		}
		return object;

	}


    /***
     *
     * @param id      id of the object to retrieve
     * @param tClass  class type of the object to retrieve
     * @param withRel such as the lazy fetch type is used for relations we need to
     *                operate in a different way if we want the related object
     * @param         <T> orm type to find
     * @return
     */
    public static <T> T getById(Integer id, Class<T> tClass, boolean withRel) {
	EntityManager em = Em.createEntityManager();
	T ormObject = em.find(tClass, id);
	Em.closeEntityManager(em);
	return ormObject;
    }

	public static boolean persistableDelete(Persistable object) {
		EntityManager em = Em.createEntityManager();
		try {

			em.getTransaction().begin();
			em.remove(object);
			Em.closeEntityManager(em);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore: " + e.getMessage());
			return false;
		}
		return true;
	}

}
