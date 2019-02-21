package com.lynx.EFintus.commercio.classes;

public class TagsProdotto {

    private int idTags;
    private int idProdotto;

    public TagsProdotto(int idTags, int idProdotto) {
	super();
	this.idTags = idTags;
	this.idProdotto = idProdotto;
    }

    public int getIdTags() {
	return idTags;
    }

    public void setIdTags(int idTags) {
	this.idTags = idTags;
    }

    public int getIdProdotto() {
	return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
	this.idProdotto = idProdotto;
    }

}
