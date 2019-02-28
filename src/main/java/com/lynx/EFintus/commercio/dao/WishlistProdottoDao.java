package com.lynx.EFintus.commercio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lynx.EFintus.commercio.classes.WishlistProdotto;
import com.lynx.EFintus.commercio.utility.Em;

public class WishlistProdottoDao extends GenericDao<WishlistProdotto> {

    public List<WishlistProdotto> getByIdWishlist(Integer idWishlist) throws SQLException {

	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select wp From WishlistProdotto wp WHERE tp.Id_Wishlist=:Id_Wishlist");
	query.setParameter("Id_Wishlist", idWishlist);
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;
    }

    public List<WishlistProdotto> getByIdProdotto(Integer idProdotto) throws SQLException {

	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select wp From WishlistProdotto wp WHERE tp.Id_Prodotto=:Id_Prodotto");
	query.setParameter("Id_Prodotto", idProdotto);
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;
    }

    @Override
    public List<WishlistProdotto> getAll() throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select wp From WishlistProdotto wp");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;
    }

    @Override
    public boolean save(WishlistProdotto wishlistProdotto) throws SQLException {
	return persistableSave(wishlistProdotto);

    }

    /**
     * Not implemented method, use delete and save
     */
    @Override
    public boolean update(WishlistProdotto t) throws SQLException {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean delete(WishlistProdotto wishlistProdotto) throws SQLException {
		return persistableDelete(wishlistProdotto);

    }

}
