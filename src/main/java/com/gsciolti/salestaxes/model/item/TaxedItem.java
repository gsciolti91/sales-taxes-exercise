package com.gsciolti.salestaxes.model.item;

import com.gsciolti.salestaxes.model.CurrencyValue;
import com.gsciolti.salestaxes.model.tax.BasicSalesTax;

/**
 * An {@link Item} on which the {@link BasicSalesTax} is applied by default
 */
public abstract class TaxedItem extends Item {

    public TaxedItem(String name, CurrencyValue price) {
        super(name, price);
        addTax(new BasicSalesTax());
    }
}
