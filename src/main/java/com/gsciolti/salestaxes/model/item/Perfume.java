package com.gsciolti.salestaxes.model.item;

public class Perfume extends TaxedItem {

    private String brand;

    public Perfume(String name, String brand, float price) {
        super(name, price);
        setBrand(brand);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
