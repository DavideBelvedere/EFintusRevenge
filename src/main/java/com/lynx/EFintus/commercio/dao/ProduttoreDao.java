package com.lynx.EFintus.commercio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lynx.EFintus.commercio.classes.Produttore;
import com.lynx.EFintus.commercio.utility.Em;

public class ProduttoreDao extends GenericDao<Produttore> {

    public Produttore getByID(Integer id) throws SQLException {
	return getById(id, Produttore.class, true);
    }

    @Override
    public List<Produttore> getAll() throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select p From produttore p");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;
    }

    @Override
    public boolean save(Produttore produttore) throws SQLException {
	return persistableSave(produttore);
    }

    @Override
    public boolean update(Produttore produttore) throws SQLException {
	return save(produttore);
    }

    @Override
    public boolean delete(Produttore produttore) throws SQLException {
	EntityManager em = Em.createEntityManager();
	try {

	    em.getTransaction().begin();
	    em.remove(produttore);
	    Em.closeEntityManager(em);

	} catch (Exception e) {
	    em.getTransaction().rollback();
	    System.out.println("Errore: " + e.getMessage());
	    return false;
	}
	return true;

    }
}
