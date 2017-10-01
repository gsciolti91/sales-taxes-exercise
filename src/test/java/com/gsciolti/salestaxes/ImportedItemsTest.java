package com.gsciolti.salestaxes;

import com.gsciolti.salestaxes.model.CurrencyValue;
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

public class ImportedItemsTest {

    @Test
    public void testImportedChocolateBarTax() {

        ChocolateBar chocolateBar = new ChocolateBar("Delicious Chocolate Bar", new CurrencyValue(.85), "Nestle", 1000, 80);

        chocolateBar.setImported(true);

        Assert.assertEquals(new CurrencyValue(0.04), chocolateBar.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(.89), chocolateBar.getTaxedPrice());
    }

    @Test
    public void testImportedChocolatesBoxTax() {

        ChocolatesBox chocolatesBox = new ChocolatesBox("Delicious Chocolates Box", new CurrencyValue(10.8), "Nestle", 10000, 30);

        chocolatesBox.setImported(true);

        Assert.assertEquals(new CurrencyValue(0.54), chocolatesBox.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(11.34), chocolatesBox.getTaxedPrice());
    }

    @Test
    public void testImportedHeadachePillsBoxTax() {

        HeadachePillsBox headachePillsBox = new HeadachePillsBox("Aspirin Box", new CurrencyValue(9.45), "", 25);

        headachePillsBox.setImported(true);

        Assert.assertEquals(new CurrencyValue(0.47), headachePillsBox.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(9.92), headachePillsBox.getTaxedPrice());
    }

    @Test
    public void testImportedBookTax() {

        Book book = new Book("The Lord of the Rings", new CurrencyValue(23.49), "J. R. R. Tolkien");

        book.setImported(true);

        Assert.assertEquals(new CurrencyValue(1.17), book.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(24.66), book.getTaxedPrice());
    }

    @Test
    public void testImportedPerfumeTax() {

        Perfume perfume = new Perfume("Chanel N. 5", new CurrencyValue(29.9), "Chanel");

        perfume.setImported(true);

        Assert.assertEquals(new CurrencyValue(4.49), perfume.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(34.39), perfume.getTaxedPrice());
    }

    @Test
    public void testImportedMusicCDTax() {

        MusicCD cd = new MusicCD("Recovery", new CurrencyValue(20.99), "Eminem", new ArrayList<Track>());

        cd.setImported(true);

        Assert.assertEquals(new CurrencyValue(3.15), cd.getTaxesAmount());
        Assert.assertEquals(new CurrencyValue(24.14), cd.getTaxedPrice());
    }
}
