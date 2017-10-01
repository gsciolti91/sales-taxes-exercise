package com.gsciolti.salestaxes.model.tax;

import com.gsciolti.salestaxes.model.CurrencyValue;
import com.gsciolti.salestaxes.model.item.Item;

public class ImportSalesTax extends SalesTax {

    @Override
    public CurrencyValue getTaxOn(Item item) {
        return new CurrencyValue(0.05).times(item.getPrice());
    }
}
