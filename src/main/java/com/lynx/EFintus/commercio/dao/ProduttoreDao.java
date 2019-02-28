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
	Query query = em.createQuery("select p From Produttore p");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;
    }

    @Override
    public Produttore save(Produttore produttore) throws SQLException {
	return (Produttore)persistableSave(produttore);
    }

    @Override
    public Produttore update(Produttore produttore) throws SQLException {
	return save(produttore);
    }

    @Override
    public boolean delete(Produttore produttore) throws SQLException {
		return persistableDelete(produttore);

    }
}
