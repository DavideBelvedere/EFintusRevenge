package com.lynx.EFintus.commercio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lynx.EFintus.commercio.classes.Ordine;
import com.lynx.EFintus.commercio.utility.Em;

public class OrdineDao extends GenericDao<Ordine> {

    public Ordine getById(Integer id) throws SQLException {
	return getById(id, Ordine.class, true);
    }

    @Override
    public List<Ordine> getAll() throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select o From Ordine o");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;
    }

    @Override
    public boolean save(Ordine ordine) throws SQLException {

	return persistableSave(ordine);

    }

    @Override
    public boolean update(Ordine ordine) throws SQLException {
	return this.save(ordine);

    }

    @Override
    public boolean delete(Ordine ordine) throws SQLException {
		return persistableDelete(ordine);

    }

}
