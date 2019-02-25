package com.lynx.EFintus.commercio.classes.primarykeys;

import java.io.Serializable;

import com.lynx.EFintus.commercio.classes.Prodotto;
import com.lynx.EFintus.commercio.classes.Utente;

public class RecensionePK implements Serializable {

    protected Utente utente;
    protected Prodotto prodotto;

    public RecensionePK() {
    }

    public RecensionePK(Utente utente, Prodotto prodotto) {
	this.utente = utente;
	this.prodotto = prodotto;
    }

}
