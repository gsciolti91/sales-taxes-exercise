package com.gsciolti.salestaxes.model;

import com.gsciolti.salestaxes.model.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

    private List<Item> items;

    public ShoppingBasket() {
    }

    public void addItem(Item item) {

        if (getItems() == null) {
            setItems(new ArrayList<Item>());
        }

        getItems().add(item);
    }

    public CurrencyValue getTotal() {

        CurrencyValue total = new CurrencyValue(0);

        if (getItems() != null) {
            for (Item item : getItems()) {
                total = total.add(item.getTaxedPrice());
            }
        }

        return total;
    }

    public CurrencyValue getTaxesAmount() {
        CurrencyValue taxesAmount = new CurrencyValue(0);

        if (getItems() != null) {
            for (Item item : getItems()) {
                taxesAmount = taxesAmount.add(item.getTaxesAmount());
            }
        }

        return taxesAmount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
