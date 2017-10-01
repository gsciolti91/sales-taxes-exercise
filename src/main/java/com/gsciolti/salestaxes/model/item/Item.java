package com.gsciolti.salestaxes.model.item;

import com.gsciolti.salestaxes.model.CurrencyValue;
import com.gsciolti.salestaxes.model.tax.ImportSalesTax;
import com.gsciolti.salestaxes.model.tax.SalesTax;

import java.util.HashSet;
import java.util.Set;

/**
 * A generic item that can be purchased
 */
public abstract class Item {

    private String name;

    private CurrencyValue price;

    private Set<SalesTax> taxes;

    private boolean imported;

    public Item(String name, CurrencyValue price) {
        setName(name);
        setPrice(price);
        setImported(false);
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
        return getPrice().add(getTaxesAmount());
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

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;

        if (imported) {
            addTax(new ImportSalesTax());
        }
    }
}
