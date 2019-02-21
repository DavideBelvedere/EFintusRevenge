package com.lynx.EFintus.commercio.classes;

import java.sql.Date;

public class WishlistProdotto {

    private int idWishlist;

    private int idProdotto;

    private Date dataInserimento;

    public WishlistProdotto(int idWishlist, int idProdotto, Date dataInserimento) {
	this.idWishlist = idWishlist;
	this.idProdotto = idProdotto;
	this.dataInserimento = dataInserimento;
    }

    public int getIdWishlist() {
	return idWishlist;
    }

    public void setIdWishlist(int idWishlist) {
	this.idWishlist = idWishlist;
    }

    public int getIdProdotto() {
	return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
	this.idProdotto = idProdotto;
    }

    public Date getDataInserimento() {
	return dataInserimento;
    }

    public void setDataInserimento(Date dataInserimento) {
	this.dataInserimento = dataInserimento;
    }

}
