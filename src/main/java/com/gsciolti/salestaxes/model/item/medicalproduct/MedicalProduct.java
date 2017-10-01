package com.gsciolti.salestaxes.model.item.medicalproduct;

import com.gsciolti.salestaxes.model.CurrencyValue;
import com.gsciolti.salestaxes.model.item.Item;

public abstract class MedicalProduct extends Item {

    public MedicalProduct(String name, CurrencyValue price) {
        super(name, price);
    }
}
