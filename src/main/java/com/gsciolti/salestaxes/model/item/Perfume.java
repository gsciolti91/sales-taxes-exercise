package com.gsciolti.salestaxes.model.item;

import com.gsciolti.salestaxes.model.CurrencyValue;

public class Perfume extends TaxedItem {

    private String brand;

    public Perfume(String name, CurrencyValue price, String brand) {
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
