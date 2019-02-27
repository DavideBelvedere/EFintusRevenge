package com.lynx.EFintus.commercio.classes.primarykeys;

import java.io.Serializable;

import com.lynx.EFintus.commercio.classes.Ordine;
import com.lynx.EFintus.commercio.classes.Prodotto;

public class OrdineProdottoPK implements Serializable {

    protected Ordine ordine;
    protected Prodotto prodotto;

    public OrdineProdottoPK() {
    }

    public OrdineProdottoPK(Ordine ordine, Prodotto prodotto) {
	this.ordine = ordine;
	this.prodotto = prodotto;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((ordine == null) ? 0 : ordine.hashCode());
	result = prime * result + ((prodotto == null) ? 0 : prodotto.hashCode());
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
	OrdineProdottoPK other = (OrdineProdottoPK) obj;
	if (ordine == null) {
	    if (other.ordine != null)
		return false;
	} else if (!ordine.equals(other.ordine))
	    return false;
	if (prodotto == null) {
	    if (other.prodotto != null)
		return false;
	} else if (!prodotto.equals(other.prodotto))
	    return false;
	return true;
    }

}
