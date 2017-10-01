package com.gsciolti.salestaxes.model.tax;

import com.gsciolti.salestaxes.model.item.Item;

public class BasicSalesTax extends SalesTax {

    public float applyTo(Item item) {
        return 1.1f*item.getPrice();
    }
}
