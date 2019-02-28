package com.lynx.EFintus.commercio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lynx.EFintus.commercio.classes.Categoria;
import com.lynx.EFintus.commercio.utility.Em;

public class CategorieDao extends GenericDao<Categoria> {

    public Categoria getById(Integer id) throws SQLException {
	return getById(id, Categoria.class, true);
    }

    @Override
    public List<Categoria> getAll() throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select c From Categoria c");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;
    }

    @Override
    public boolean save(Categoria categoria) throws SQLException {
	return persistableSave(categoria);
    }

    @Override
    public boolean update(Categoria categoria) throws SQLException {

	return this.save(categoria);

    }

    @Override
    public boolean delete(Categoria categoria) throws SQLException {
		return persistableDelete(categoria);

    }

}
