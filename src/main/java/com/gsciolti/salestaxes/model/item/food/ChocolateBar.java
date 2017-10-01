package com.gsciolti.salestaxes.model.item.food;

import com.gsciolti.salestaxes.model.CurrencyValue;

public class ChocolateBar extends Food {

    private float weight;

    public ChocolateBar(String name, CurrencyValue price, String brand, int calories, float weight) {
        super(name, price, brand, calories);
        setWeight(weight);
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
