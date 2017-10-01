package com.gsciolti.salestaxes.model.item.medicalproduct;

import com.gsciolti.salestaxes.model.CurrencyValue;

public class HeadachePillsBox extends MedicalProduct {

    private String brand;

    private int size;

    public HeadachePillsBox(String name, CurrencyValue price, String brand, int size) {
        super(name, price);
        setBrand(brand);
        setSize(size);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
