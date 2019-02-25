package com.lynx.EFintus.commercio.classes.primarykeys;

import java.io.Serializable;

import com.lynx.EFintus.commercio.classes.Prodotto;
import com.lynx.EFintus.commercio.classes.Tags;

public class TagsProdottoPK implements Serializable {

    protected Tags tags;
    protected Prodotto prodotto;

    public TagsProdottoPK() {
    }

    public TagsProdottoPK(Tags tags, Prodotto prodotto) {
	this.tags = tags;
	this.prodotto = prodotto;
    }
}
