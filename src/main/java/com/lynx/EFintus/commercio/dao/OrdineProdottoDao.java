package com.lynx.EFintus.commercio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lynx.EFintus.commercio.classes.OrdineProdotto;
import com.lynx.EFintus.commercio.utility.Em;

public class OrdineProdottoDao extends GenericDao<OrdineProdotto> {

    public OrdineProdotto getById(Integer idProdotto, Integer idOrdine) throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery(
		"select op From OrdineProdotto op WHERE op.Id_prodotto=:Id_prodotto & op.Id_ordine=:Id_ordine");
	query.setParameter("Id_prodotto", idProdotto);
	query.setParameter("Id_ordine", idOrdine);
	OrdineProdotto results = (OrdineProdotto) query.getSingleResult();
	Em.closeEntityManager(em);
	if (results == null) {
	    return results;
	}
	return null;
    }

    @Override
    public List<OrdineProdotto> getAll() throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select op From OrdineProdotto op");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;

    }

    @Override
    public boolean save(OrdineProdotto ordersProducts) throws SQLException {
	return persistableSave(ordersProducts);
    }

    @Override
    public boolean update(OrdineProdotto ordersProducts) throws SQLException {

	return this.save(ordersProducts);
    }

    @Override
    public boolean delete(OrdineProdotto ordersProducts) throws SQLException {
		return persistableDelete(ordersProducts);
    }

}
