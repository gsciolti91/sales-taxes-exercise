package com.gsciolti.salestaxes.model.item;

import com.gsciolti.salestaxes.model.tax.SalesTax;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public abstract class Item {

    private final String id = UUID.randomUUID().toString();

    private String name;

    private float price;

    private Set<SalesTax> taxes;

    public Item(String name, float price) {
        setName(name);
        setPrice(price);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public float getTaxedPrice() {

        if (getTaxes() == null || getTaxes().isEmpty()) {
            return getPrice();
        }

        float taxedPrice = 0.0f;

        for (SalesTax tax : getTaxes()) {
            taxedPrice+= tax.applyTo(this);
        }

        return taxedPrice;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setTaxes(Set<SalesTax> taxes) {
        this.taxes = taxes;
    }

    public Set<SalesTax> getTaxes() {
        return taxes;
    }

    public void addTax(SalesTax salesTax) {
        if (getTaxes() == null) {
            setTaxes(new HashSet<SalesTax>());
        }

        getTaxes().add(salesTax);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Item)) {
            return false;
        }

        Item item = (Item)obj;

        return this == item || getId().equals(item.getId());
    }
}
