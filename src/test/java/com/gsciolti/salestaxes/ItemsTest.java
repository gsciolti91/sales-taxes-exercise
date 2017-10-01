package com.gsciolti.salestaxes;

import com.gsciolti.salestaxes.model.CurrencyValue;
import com.gsciolti.salestaxes.model.item.Book;
import com.gsciolti.salestaxes.model.item.MusicCD;
import com.gsciolti.salestaxes.model.item.Perfume;
import com.gsciolti.salestaxes.model.item.Track;
import com.gsciolti.salestaxes.model.item.food.ChocolateBar;
import com.gsciolti.salestaxes.model.item.food.ChocolatesBox;
import com.gsciolti.salestaxes.model.item.medicalproduct.HeadachePillsBox;
import com.gsciolti.salestaxes.model.tax.BasicSalesTax;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ItemsTest {

    @Test
    public void testChocolateBarTax() {

        ChocolateBar chocolateBar = new ChocolateBar("Delicious Chocolate Bar", new CurrencyValue(.85), "Nestle", 1000, 80);

        Assert.assertEquals(new CurrencyValue(0), chocolateBar.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(.85), chocolateBar.getTaxedPrice());
    }

    @Test
    public void testChocolatesBoxTax() {

        ChocolatesBox chocolatesBox = new ChocolatesBox("Delicious Chocolates Box", new CurrencyValue(10.8), "Nestle", 10000, 30);

        Assert.assertEquals(new CurrencyValue(0), chocolatesBox.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(10.8), chocolatesBox.getTaxedPrice());
    }

    @Test
    public void testHeadachePillsBoxTax() {

        HeadachePillsBox headachePillsBox = new HeadachePillsBox("Aspirin Box", new CurrencyValue(9.45), "Aspirin", 25);

        Assert.assertEquals(new CurrencyValue(0), headachePillsBox.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(9.45), headachePillsBox.getTaxedPrice());
    }

    @Test
    public void testBookTax() {

        Book book = new Book("The Lord of the Rings", new CurrencyValue(23.49), "J. R. R. Tolkien");

        Assert.assertEquals(new CurrencyValue(0), book.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(23.49), book.getTaxedPrice());
    }

    @Test
    public void testPerfumeTax() {

        Perfume perfume = new Perfume("Chanel N. 5", new CurrencyValue(29.9), "Chanel");

        Assert.assertEquals(new CurrencyValue(3.00), perfume.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(32.90), perfume.getTaxedPrice());
    }

    @Test
    public void testMusicCDTax() {

        MusicCD cd = new MusicCD("Recovery", new CurrencyValue(20.99), "Eminem", new ArrayList<Track>());

        Assert.assertEquals(new CurrencyValue(2.1), cd.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(23.09), cd.getTaxedPrice());
    }

    @Test
    public void testTaxAppliedTwice() {

        MusicCD cd = new MusicCD("Recovery", new CurrencyValue(20.99), "Eminem", new ArrayList<Track>());

        cd.addTax(new BasicSalesTax());

        /*
         * A tax can only be applied once
         */
        Assert.assertEquals(new CurrencyValue(2.1), cd.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(23.09), cd.getTaxedPrice());
    }

    @Test
    public void testRemoveTax() {

        MusicCD cd = new MusicCD("Recovery", new CurrencyValue(20.99), "Eminem", new ArrayList<Track>());

        cd.removeTax(new BasicSalesTax());

        Assert.assertEquals(new CurrencyValue(0), cd.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(20.99), cd.getTaxedPrice());
    }
}
