package com.lynx.EFintus.commercio.classes.primarykeys;

import com.lynx.EFintus.commercio.classes.Ordine;
import com.lynx.EFintus.commercio.classes.Prodotto;

public class OrdineProdottoPK {

    protected Ordine ordine;
    protected Prodotto prodotto;

    public OrdineProdottoPK() {
    }

    public OrdineProdottoPK(Ordine ordine, Prodotto prodotto) {
	this.ordine = ordine;
	this.prodotto = prodotto;
    }

}
