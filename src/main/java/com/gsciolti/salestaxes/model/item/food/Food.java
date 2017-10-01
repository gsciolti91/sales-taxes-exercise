package com.gsciolti.salestaxes.model.item.food;

import com.gsciolti.salestaxes.model.CurrencyValue;
import com.gsciolti.salestaxes.model.item.Item;

public abstract class Food extends Item {

    private String brand;

    private int calories;

    public Food(String name, CurrencyValue price, String brand, int calories) {
        super(name, price);
        setBrand(brand);
        setCalories(calories);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
