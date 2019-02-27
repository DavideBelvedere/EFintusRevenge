package com.lynx.EFintus.commercio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lynx.EFintus.commercio.classes.WishList;

import logistica.Utility.Em;

public class WishListDao extends GenericDao<WishList> {

    public WishList getById(Integer id) throws SQLException {
	return getById(id, WishList.class, true);

    }

    @Override
    public List<WishList> getAll() throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select w From wishlist w");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;

    }

    @Override
    public boolean save(WishList wishLists) throws SQLException {
	return persistableSave(wishLists);
    }

    @Override
    public boolean update(WishList wishLists) throws SQLException {

	return save(wishLists);
    }

    @Override
    public boolean delete(WishList wishLists) throws SQLException {
	EntityManager em = Em.createEntityManager();
	try {

	    em.getTransaction().begin();
	    em.remove(wishLists);
	    Em.closeEntityManager(em);

	} catch (Exception e) {
	    em.getTransaction().rollback();
	    System.out.println("Errore: " + e.getMessage());
	    return false;
	}
	return true;
    }

}
