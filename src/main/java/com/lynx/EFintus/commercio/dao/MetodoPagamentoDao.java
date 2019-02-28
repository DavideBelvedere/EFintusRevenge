package com.lynx.EFintus.commercio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lynx.EFintus.commercio.classes.MetodoPagamento;
import com.lynx.EFintus.commercio.utility.Em;

public class MetodoPagamentoDao extends GenericDao<MetodoPagamento> {

    public MetodoPagamento getByName(String name) throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select mp From MetodoPagamento mp WHERE mp.metodo_pagamento=:metodo_pagamento");
	query.setParameter("metodo_pagamento", name);
	MetodoPagamento results = (MetodoPagamento) query.getSingleResult();
	Em.closeEntityManager(em);
	if (results == null) {
	    return results;
	}
	return null;
    }

    @Override
    public List<MetodoPagamento> getAll() throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select mp From MetodoPagamento mp");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;
    }

    @Override
    public MetodoPagamento save(MetodoPagamento metodoPagamento) throws SQLException {
	return (MetodoPagamento) persistableSave(metodoPagamento);

    }

    /**
     * Not implemented method, use delete and save
     */
    @Override
    public MetodoPagamento update(MetodoPagamento metodoPagamento) throws SQLException {

	// Not implemented
	return null;

    }

    @Override
    public boolean delete(MetodoPagamento metodoPagamento) throws SQLException {
		return persistableDelete(metodoPagamento);

    }
}
