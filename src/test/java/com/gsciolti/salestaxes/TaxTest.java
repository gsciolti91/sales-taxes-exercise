package com.gsciolti.salestaxes;

import org.junit.Assert;
import org.junit.Test;

public class TaxTest {

    @Test
    public void testTaxComputation() {

        Assert.assertEquals(12.52f, Math.round(12.522f*100)/100f, 0.0);

        float p = 14.99f;
        float r = .1f;

        Assert.assertEquals(16.49f, Math.round((1+r)*p*100)/100f, 0.0);
    }
}
