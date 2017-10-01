package com.gsciolti.salestaxes.model.tax;

public class ImportSalesTax extends SalesTax {

    @Override
    public double rate() {
        return .05;
    }
}
