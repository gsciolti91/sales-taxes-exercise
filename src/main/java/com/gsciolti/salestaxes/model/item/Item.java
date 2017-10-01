package com.gsciolti.salestaxes.model.item;

import com.gsciolti.salestaxes.model.CurrencyValue;
import com.gsciolti.salestaxes.model.tax.SalesTax;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public abstract class Item {

    private final String id = UUID.randomUUID().toString();

    private String name;

    private CurrencyValue price;

    private Set<SalesTax> taxes;

    public Item(String name, CurrencyValue price) {
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

    public CurrencyValue getPrice() {
        return price;
    }

    public CurrencyValue getTaxesAmount() {

        CurrencyValue taxesAmount = new CurrencyValue(0);

        if (getTaxes() != null) {
            for (SalesTax tax : getTaxes()) {
                taxesAmount = taxesAmount.add(tax.getTaxOn(this));
            }
        }

        return taxesAmount;
    }

    public CurrencyValue getTaxedPrice() {

        if (getTaxes() == null || getTaxes().isEmpty()) {
            return getPrice();
        }

        CurrencyValue taxedPrice = new CurrencyValue(0.0);

        for (SalesTax tax : getTaxes()) {
            taxedPrice = taxedPrice.add(tax.applyTo(this));
        }

        return taxedPrice;
    }

    public void setPrice(CurrencyValue price) {
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
