package com.gsciolti.salestaxes.model.tax;

public class BasicSalesTax extends SalesTax {

    @Override
    public double rate() {
        return .1;
    }
}
