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

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((prodotto == null) ? 0 : prodotto.hashCode());
	result = prime * result + ((utente == null) ? 0 : utente.hashCode());
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
	RecensionePK other = (RecensionePK) obj;
	if (prodotto == null) {
	    if (other.prodotto != null)
		return false;
	} else if (!prodotto.equals(other.prodotto))
	    return false;
	if (utente == null) {
	    if (other.utente != null)
		return false;
	} else if (!utente.equals(other.utente))
	    return false;
	return true;
    }

}
