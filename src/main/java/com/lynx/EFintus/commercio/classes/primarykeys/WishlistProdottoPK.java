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
}
