package com.lynx.EFintus.commercio.classes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lynx.EFintus.commercio.classes.persistable.Persistable;
import com.lynx.EFintus.commercio.classes.primarykeys.TagsProdottoPK;

@Entity
@Table(name = "tags_prodotto")
@IdClass(TagsProdottoPK.class)
public class TagsProdotto implements Persistable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Tags")
    private Tags tags;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Prodotto")
    private Prodotto prodotto;

    public TagsProdotto() {
    }

    public Tags getTags() {
	return tags;
    }

    public void setTags(Tags tags) {
	this.tags = tags;
    }

    public Prodotto getProdotto() {
	return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
	this.prodotto = prodotto;
    }

}
