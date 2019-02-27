package com.lynx.EFintus.commercio.utility;

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
	entityManagerFactory.close();
    }

}
