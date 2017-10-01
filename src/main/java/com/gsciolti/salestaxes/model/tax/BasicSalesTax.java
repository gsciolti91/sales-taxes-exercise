package com.gsciolti.salestaxes.model.tax;

import com.gsciolti.salestaxes.model.CurrencyValue;
import com.gsciolti.salestaxes.model.item.Item;

public class BasicSalesTax extends SalesTax {

    @Override
    public CurrencyValue getTaxOn(Item item) {
        return new CurrencyValue(0.1).times(item.getPrice());
    }
}
