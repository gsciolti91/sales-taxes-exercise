package com.gsciolti.salestaxes.model.tax;

import com.gsciolti.salestaxes.model.item.Item;

public abstract class SalesTax {

    public abstract float applyTo(Item item);
}
