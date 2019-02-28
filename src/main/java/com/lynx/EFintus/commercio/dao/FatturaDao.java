package com.lynx.EFintus.commercio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lynx.EFintus.commercio.classes.Fattura;
import com.lynx.EFintus.commercio.utility.Em;

public class FatturaDao extends GenericDao<Fattura> {

    public Fattura getById(Integer id) throws SQLException {
	return getById(id, Fattura.class, true);
    }

    @Override
    public List<Fattura> getAll() throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select f From Fattura f");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;
    }

    @Override
    public boolean save(Fattura fattura) throws SQLException {
	return persistableSave(fattura);

    }

    @Override
    public boolean update(Fattura fattura) throws SQLException {
	return this.save(fattura);

    }

    @Override
    public boolean delete(Fattura fattura) throws SQLException {
		return persistableDelete(fattura);

    }

}
