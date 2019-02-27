package com.lynx.EFintus.commercio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lynx.EFintus.commercio.classes.Tags;
import com.lynx.EFintus.commercio.utility.Em;

public class TagsDao extends GenericDao<Tags> {

    public Tags getById(Integer id) throws SQLException {
	return getById(id, Tags.class, true);

    }

    @Override
    public List<Tags> getAll() throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select t From tags t");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;

    }

    @Override
    public boolean save(Tags tags) throws SQLException {
	return persistableSave(tags);
    }

    @Override
    public boolean update(Tags tags) throws SQLException {

	return save(tags);
    }

    @Override
    public boolean delete(Tags tags) throws SQLException {
	EntityManager em = Em.createEntityManager();
	try {

	    em.getTransaction().begin();
	    em.remove(tags);
	    Em.closeEntityManager(em);

	} catch (Exception e) {
	    em.getTransaction().rollback();
	    System.out.println("Errore: " + e.getMessage());
	    return false;
	}
	return true;

    }

}
