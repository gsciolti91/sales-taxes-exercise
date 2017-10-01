package com.gsciolti.salestaxes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    CurrencyValueTest.class,
    ItemsTest.class,
    ImportedItemsTest.class
})
public class TestSuite {
}
