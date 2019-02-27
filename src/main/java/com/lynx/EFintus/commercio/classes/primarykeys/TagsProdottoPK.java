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

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((prodotto == null) ? 0 : prodotto.hashCode());
	result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
	TagsProdottoPK other = (TagsProdottoPK) obj;
	if (prodotto == null) {
	    if (other.prodotto != null)
		return false;
	} else if (!prodotto.equals(other.prodotto))
	    return false;
	if (tags == null) {
	    if (other.tags != null)
		return false;
	} else if (!tags.equals(other.tags))
	    return false;
	return true;
    }

}
