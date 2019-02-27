package com.lynx.EFintus.commercio.classes.primarykeys;

import java.io.Serializable;

import com.lynx.EFintus.commercio.classes.Prodotto;
import com.lynx.EFintus.commercio.classes.WishList;

public class WishlistProdottoPK implements Serializable {

    protected WishList wishlist;
    protected Prodotto prodotto;

    public WishlistProdottoPK() {
    }

    public WishlistProdottoPK(WishList wishlist, Prodotto prodotto) {
	this.wishlist = wishlist;
	this.prodotto = prodotto;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((prodotto == null) ? 0 : prodotto.hashCode());
	result = prime * result + ((wishlist == null) ? 0 : wishlist.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	WishlistProdottoPK other = (WishlistProdottoPK) obj;
	if (prodotto == null) {
	    if (other.prodotto != null)
		return false;
	} else if (!prodotto.equals(other.prodotto))
	    return false;
	if (wishlist == null) {
	    if (other.wishlist != null)
		return false;
	} else if (!wishlist.equals(other.wishlist))
	    return false;
	return true;
    }

}
