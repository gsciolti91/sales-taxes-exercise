package com.gsciolti.salestaxes.model.item;

public class Book extends Item {

    private String author;

    public Book(String name, String author, float price) {
        super(name, price);
        setAuthor(author);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
