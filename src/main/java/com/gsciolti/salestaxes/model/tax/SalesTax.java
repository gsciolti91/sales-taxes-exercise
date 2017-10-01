package com.gsciolti.salestaxes.model.tax;

import com.gsciolti.salestaxes.model.CurrencyValue;
import com.gsciolti.salestaxes.model.item.Item;

public abstract class SalesTax {

    public CurrencyValue applyTo(Item item) {
        return item.getPrice().add(getTaxOn(item));
    }

    public abstract CurrencyValue getTaxOn(Item item);
}
