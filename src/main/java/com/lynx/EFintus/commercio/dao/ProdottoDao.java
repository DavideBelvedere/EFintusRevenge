package com.lynx.EFintus.commercio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lynx.EFintus.commercio.classes.Prodotto;
import com.lynx.EFintus.commercio.utility.Em;

public class ProdottoDao extends GenericDao<Prodotto> {

    public Prodotto getById(Integer id) throws SQLException {
	return getById(id, Prodotto.class, true);

    }

    @Override
    public List<Prodotto> getAll() throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select p From Prodotto p");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;

    }

    @Override
    public boolean save(Prodotto products) throws SQLException {
	return persistableSave(products);
    }

    @Override
    public boolean update(Prodotto products) throws SQLException {

	return save(products);
    }

    @Override
    public boolean delete(Prodotto products) throws SQLException {
		return persistableDelete(products);

    }

}
