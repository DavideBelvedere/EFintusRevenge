package com.lynx.EFintus.commercio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lynx.EFintus.commercio.classes.MetodoPagamento;

import logistica.Utility.Em;

public class MetodoPagamentoDao extends GenericDao<MetodoPagamento> {

    public MetodoPagamento getByName(String name) throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select mp From metodo_pagamento mp WHERE mp.metodo_pagamento=:metodo_pagamento");
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
	Query query = em.createQuery("select mp From metodo_pagamento mp");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;
    }

    @Override
    public boolean save(MetodoPagamento metodoPagamento) throws SQLException {
	return persistableSave(metodoPagamento);

    }

    /**
     * Not implemented method, use delete and save
     */
    @Override
    public boolean update(MetodoPagamento metodoPagamento) throws SQLException {

	// Not implemented
	return false;

    }

    @Override
    public boolean delete(MetodoPagamento metodoPagamento) throws SQLException {
	EntityManager em = Em.createEntityManager();
	try {

	    em.getTransaction().begin();
	    em.remove(metodoPagamento);
	    Em.closeEntityManager(em);

	} catch (Exception e) {
	    em.getTransaction().rollback();
	    System.out.println("Errore: " + e.getMessage());
	    return false;
	}
	return true;

    }
}
