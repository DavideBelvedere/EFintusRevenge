package com.lynx.EFintus.commercio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lynx.EFintus.commercio.classes.Utente;
import com.lynx.EFintus.commercio.utility.Em;

public class UtenteDao extends GenericDao<Utente> {

    public Utente getByID(Integer id) throws SQLException {
	return getById(id, Utente.class, true);

    }

    @Override
    public List<Utente> getAll() throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select u From Utente u");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;

    }

    @Override
    public boolean save(Utente utente) throws SQLException {
	return persistableSave(utente);
    }

    @Override
    public boolean update(Utente utente) throws SQLException {

	return save(utente);
    }

    @Override
    public boolean delete(Utente utente) throws SQLException {
		return persistableDelete(utente);
    }

}
