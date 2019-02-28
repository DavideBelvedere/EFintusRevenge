package com.lynx.EFintus.commercio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lynx.EFintus.commercio.classes.WishList;
import com.lynx.EFintus.commercio.utility.Em;

public class WishListDao extends GenericDao<WishList> {

    public WishList getById(Integer id) throws SQLException {
	return getById(id, WishList.class, true);

    }

    @Override
    public List<WishList> getAll() throws SQLException {
	EntityManager em = Em.createEntityManager();
	Query query = em.createQuery("select w From Wishlist w");
	List results = query.getResultList();
	Em.closeEntityManager(em);
	if (!results.isEmpty()) {
	    return results;
	}
	return null;

    }

    @Override
    public WishList save(WishList wishLists) throws SQLException {
	return (WishList)persistableSave(wishLists);
    }

    @Override
    public WishList update(WishList wishLists) throws SQLException {

	return save(wishLists);
    }

    @Override
    public boolean delete(WishList wishLists) throws SQLException {
		return persistableDelete(wishLists);
    }

}
