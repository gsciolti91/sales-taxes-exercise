package com.gsciolti.salestaxes;

import com.gsciolti.salestaxes.model.CurrencyValue;
import com.gsciolti.salestaxes.model.ShoppingBasket;
import com.gsciolti.salestaxes.model.item.Book;
import com.gsciolti.salestaxes.model.item.MusicCD;
import com.gsciolti.salestaxes.model.item.Perfume;
import com.gsciolti.salestaxes.model.item.Track;
import com.gsciolti.salestaxes.model.item.food.ChocolateBar;
import com.gsciolti.salestaxes.model.item.food.ChocolatesBox;
import com.gsciolti.salestaxes.model.item.medicalproduct.HeadachePillsBox;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ShoppingBasketTest {

    @Test
    public void testShoppingBasket() {

        /*
         * Input 1
         */
        ShoppingBasket shoppingBasket1 = new ShoppingBasket();

        shoppingBasket1.addItem(new Book("The Lord of the Rings", new CurrencyValue(12.49), "J. R. R. Tolkien"));
        shoppingBasket1.addItem(new MusicCD("Recovery", new CurrencyValue(14.99), "Eminem", new ArrayList<Track>()));
        shoppingBasket1.addItem(new ChocolateBar("Delicious Chocolate Bar", new CurrencyValue(.85), "Nestle", 1000, 80));

        Assert.assertEquals(new CurrencyValue(1.50), shoppingBasket1.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(29.83), shoppingBasket1.getTotal());

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

        Assert.assertEquals(new CurrencyValue(7.65), shoppingBasket2.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(65.15), shoppingBasket2.getTotal());

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

        Assert.assertEquals(new CurrencyValue(6.70), shoppingBasket3.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(74.68), shoppingBasket3.getTotal());
    }
}
