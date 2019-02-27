package com.lynx.EFintus.commercio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lynx.EFintus.commercio.classes.TagsProdotto;

import logistica.Utility.Em;

public class TagsProdottoDao extends GenericDao<TagsProdotto> {

    public List<TagsProdotto> getByIdTags(Integer idTags) throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select tp From tags_prodotto tp WHERE tp.Id_Tags=:Id_Tags");
	query.setParameter("Id_Tags", idTags);
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;
    }

    public List<TagsProdotto> getByIdProdotto(Integer idProdotto) throws SQLException {

	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select tp From tags_prodotto tp WHERE tp.Id_Prodotto=:Id_Prodotto");
	query.setParameter("Id_Prodotto", idProdotto);
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;
    }

    @Override
    public List<TagsProdotto> getAll() throws SQLException {

	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select tp From tags_prodotto tp");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;
    }

    @Override
    public boolean save(TagsProdotto tagsProdotto) throws SQLException {
	return persistableSave(tagsProdotto);

    }

    /**
     * Not implemented method, use delete and save
     */
    @Override
    public boolean update(TagsProdotto tagsProdotto) throws SQLException {
	return save(tagsProdotto);

    }

    @Override
    public boolean delete(TagsProdotto tagsProdotto) throws SQLException {
	EntityManager em = Em.createEntityManager();
	try {

	    em.getTransaction().begin();
	    em.remove(tagsProdotto);
	    Em.closeEntityManager(em);

	} catch (Exception e) {
	    em.getTransaction().rollback();
	    System.out.println("Errore: " + e.getMessage());
	    return false;
	}
	return true;

    }

}
