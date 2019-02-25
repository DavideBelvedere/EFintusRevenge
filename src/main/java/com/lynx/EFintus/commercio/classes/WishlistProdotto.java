package com.lynx.EFintus.commercio.classes;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lynx.EFintus.commercio.classes.primarykeys.WishlistProdottoPK;

@Entity
@Table(name = "wishlist_prodotto")
@IdClass(WishlistProdottoPK.class)
public class WishlistProdotto {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Wishlist")
    private WishList wishlist;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Prodotto")
    private Prodotto prodotto;

    @Column(name = "DataInserimento")
    private Date dataInserimento;

    public WishlistProdotto() {

    }

    public WishList getWishlist() {
	return wishlist;
    }

    public void setWishlist(WishList wishlist) {
	this.wishlist = wishlist;
    }

    public Prodotto getProdotto() {
	return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
	this.prodotto = prodotto;
    }

    public Date getDataInserimento() {
	return dataInserimento;
    }

    public void setDataInserimento(Date dataInserimento) {
	this.dataInserimento = dataInserimento;
    }

}
