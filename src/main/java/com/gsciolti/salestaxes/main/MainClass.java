package com.gsciolti.salestaxes.main;

import com.gsciolti.salestaxes.model.CurrencyValue;
import com.gsciolti.salestaxes.model.ShoppingBasket;
import com.gsciolti.salestaxes.model.item.*;
import com.gsciolti.salestaxes.model.item.food.ChocolateBar;
import com.gsciolti.salestaxes.model.item.food.ChocolatesBox;
import com.gsciolti.salestaxes.model.item.medicalproduct.HeadachePillsBox;

import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) {

        /*
         * Input 1
         */
        ShoppingBasket shoppingBasket1 = new ShoppingBasket();

        shoppingBasket1.addItem(new Book("The Lord of the Rings", new CurrencyValue(12.49), "J. R. R. Tolkien"));
        shoppingBasket1.addItem(new MusicCD("Recovery", new CurrencyValue(14.99), "Eminem", new ArrayList<Track>()));
        shoppingBasket1.addItem(new ChocolateBar("Delicious Chocolate Bar", new CurrencyValue(.85), "Nestle", 1000, 80));

        System.out.println("SHOPPING BASKET 1");
        printReceiptFor(shoppingBasket1);

        /*
         * Input 2
         */
        ShoppingBasket shoppingBasket2 = new ShoppingBasket();

        ChocolatesBox importedChocolatesBox = new ChocolatesBox("Delicious Chocolates Box", new CurrencyValue(10.00), "Nestle", 10000, 30);
        importedChocolatesBox.setImported(true);

        Perfume importedPerfume = new Perfume("Chanel N. 5", new CurrencyValue(47.50), "Chanel");
        importedPerfume.setImported(true);

        shoppingBasket2.addItem(importedChocolatesBox);
        shoppingBasket2.addItem(importedPerfume);

        System.out.println("SHOPPING BASKET 2");
        printReceiptFor(shoppingBasket2);

        /*
         * Input 3
         */
        ShoppingBasket shoppingBasket3 = new ShoppingBasket();

        importedPerfume.setPrice(new CurrencyValue(27.99));
        importedChocolatesBox.setPrice(new CurrencyValue(11.25));

        shoppingBasket3.addItem(importedPerfume);
        shoppingBasket3.addItem(new Perfume("Boss Bottled", new CurrencyValue(18.99), "Hugo Boss"));
        shoppingBasket3.addItem(new HeadachePillsBox("Aspirin Box", new CurrencyValue(9.75), "Aspirin", 25));
        shoppingBasket3.addItem(importedChocolatesBox);

        System.out.println("SHOPPING BASKET 3");
        printReceiptFor(shoppingBasket3);
    }

    private static void printReceiptFor(ShoppingBasket shoppingBasket) {

        for (Item item : shoppingBasket.getItems()) {
            System.out.println(String.format("1 %s at %s", item, item.getTaxedPrice()));
        }

        System.out.println(String.format("Sales Taxes: %s", shoppingBasket.getTaxesAmount()));
        System.out.println(String.format("Total: %s\n", shoppingBasket.getTotal()));
    }
}
