package com.lynx.EFintus.commercio.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Em {

    private final static EntityManagerFactory entityManagerFactory = Persistence
	    .createEntityManagerFactory("efintus_commerciale");

    public static EntityManager createEntityManager() {
	return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManager(EntityManager em) {
     em.close();

    }
    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }

}
