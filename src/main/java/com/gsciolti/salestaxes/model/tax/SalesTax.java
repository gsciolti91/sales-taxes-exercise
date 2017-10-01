package com.gsciolti.salestaxes.model.tax;

import com.gsciolti.salestaxes.model.CurrencyValue;
import com.gsciolti.salestaxes.model.item.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A generic sales tax that can be applied to an {@link Item}
 */
public abstract class SalesTax {

    public static final BigDecimal ROUNDING = BigDecimal.valueOf(.05);

    public abstract double rate();

    public CurrencyValue applyTo(Item item) {
        return item.getPrice().add(getTaxOn(item));
    }

    public CurrencyValue getTaxOn(Item item) {

        BigDecimal initial = BigDecimal.valueOf(rate()).multiply(item.getPrice().getValue());
        BigDecimal rounded = initial.divide(ROUNDING, 0, RoundingMode.UP).multiply(ROUNDING);

        return new CurrencyValue(rounded);
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().getCanonicalName().equals(getClass().getCanonicalName());
    }

    @Override
    public int hashCode() {
        return getClass().getCanonicalName().hashCode();
    }
}
