package com.gsciolti.salestaxes.model.item.food;

import com.gsciolti.salestaxes.model.CurrencyValue;

public class ChocolatesBox extends Food {

    public ChocolatesBox(String name, CurrencyValue price, String brand, int calories, int size) {
        super(name, price, brand, calories);
        setSize(size);
    }

    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("%sbox of chocolates: \"%s\"", isImported()? "imported ": "", getName());
    }
}
