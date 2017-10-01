package com.gsciolti.salestaxes;

import com.gsciolti.salestaxes.model.item.Perfume;
import org.junit.Assert;
import org.junit.Test;

public class ItemsTest {

    @Test
    public void testPerfumeTax() {

        Perfume perfume = new Perfume("Chanel N. 5", "Chanel", 29.9f);

        Assert.assertEquals(32.89f, perfume.getTaxedPrice(), 0.0);
    }
}
