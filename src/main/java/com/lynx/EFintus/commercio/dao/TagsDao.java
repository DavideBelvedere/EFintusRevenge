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
	Query query = em.createQuery("select t From Tags t");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;

    }

    @Override
    public Tags save(Tags tags) throws SQLException {
	return (Tags)persistableSave(tags);
    }

    @Override
    public Tags update(Tags tags) throws SQLException {

	return save(tags);
    }

    @Override
    public boolean delete(Tags tags) throws SQLException {
		return persistableDelete(tags);

    }

}
