package com.gsciolti.salestaxes.model.item;

import com.gsciolti.salestaxes.model.CurrencyValue;

public class Book extends Item {

    private String author;

    public Book(String name, CurrencyValue price, String author) {
        super(name, price);
        setAuthor(author);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("%sbook: \"%s\"", isImported()? "imported ": "", getName());
    }
}
