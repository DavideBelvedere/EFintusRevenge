package com.lynx.EFintus.commercio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lynx.EFintus.commercio.classes.Recensione;
import com.lynx.EFintus.commercio.utility.Em;

public class RecensioneDao extends GenericDao<Recensione> {

    public Recensione getByID(Integer id_utente, Integer id_prodotto) throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em
		.createQuery("select r From Recensione r WHERE op.Id_prodotto=:Id_prodotto & op.Id_utente=:Id_utente");
	query.setParameter("Id_prodotto", id_prodotto);
	query.setParameter("Id_utente", id_utente);
	Recensione results = (Recensione) query.getSingleResult();
	Em.closeEntityManager(em);
	if (results == null) {
	    return results;
	}
	return null;
    }

    @Override
    public List<Recensione> getAll() throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select r From Recensione r");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;
    }

    @Override
    public Recensione save(Recensione recensione) throws SQLException {
	return (Recensione)persistableSave(recensione);
    }

    @Override
    public Recensione update(Recensione recensione) throws SQLException {
	return save(recensione);
    }

    @Override
    public boolean delete(Recensione recensione) throws SQLException {
		return persistableDelete(recensione);
    }

}
