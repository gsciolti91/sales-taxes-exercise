package com.gsciolti.salestaxes;

import com.gsciolti.salestaxes.model.CurrencyValue;
import com.gsciolti.salestaxes.model.item.Book;
import org.junit.Assert;
import org.junit.Test;

public class CurrencyValueTest {

    @Test
    public void testCurrencyValue() {

        CurrencyValue currencyValue1 = new CurrencyValue(19.99);
        CurrencyValue currencyValue2 = new CurrencyValue(19.955);
        CurrencyValue currencyValue3 = new CurrencyValue(19.956);
        CurrencyValue currencyValue4 = new CurrencyValue(19.954);
        CurrencyValue currencyValue5 = new CurrencyValue(199.954);

        Assert.assertEquals(new CurrencyValue(19.99), currencyValue1);
        Assert.assertEquals(new CurrencyValue(19.96), currencyValue2);
        Assert.assertEquals(new CurrencyValue(19.96), currencyValue3);
        Assert.assertEquals(new CurrencyValue(19.95), currencyValue4);
        Assert.assertEquals(new CurrencyValue(199.95), currencyValue5);
    }

    @Test
    public void testBookPrice() {

        Book book = new Book("Harry Potter and the Philospher's Stone", new CurrencyValue(19.999), "J. K. Rowling");

        Assert.assertEquals(new CurrencyValue(20), book.getPrice());
    }
}
