package com.gsciolti.salestaxes.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * A class to work with currency values
 */
public class CurrencyValue {

    public static final MathContext DEFAULT_CONTEXT = new MathContext(0, RoundingMode.HALF_EVEN);

    private BigDecimal value;

    public CurrencyValue(double val) {
        setValue(BigDecimal.valueOf(val));
        scale();
    }

    public CurrencyValue(BigDecimal val) {
        setValue(val);
        scale();
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof CurrencyValue)) {
            return false;
        }

        CurrencyValue currencyValue = (CurrencyValue)o;

        return currencyValue.getValue().compareTo(getValue()) == 0;
    }

    public CurrencyValue add(CurrencyValue augend) {
        return new CurrencyValue(getValue().add(augend.getValue(), DEFAULT_CONTEXT));
    }

    public CurrencyValue times(CurrencyValue multiplicand) {
        return new CurrencyValue(getValue().multiply(multiplicand.getValue(), DEFAULT_CONTEXT));
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String toString() {
        return getValue().toString();
    }

    public String toPlainString() {
        return getValue().toPlainString();
    }

    private void scale() {
        setValue(getValue().setScale(2, BigDecimal.ROUND_HALF_UP));
    }
}
