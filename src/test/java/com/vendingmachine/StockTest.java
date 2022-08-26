package com.vendingmachine;

import org.junit.Assert;
import org.junit.Test;

public class StockTest {
    @Test
    public void stockIsCreated() {
        Stock product1 = new Stock("Milka Leger", "A01", 0.60, 10);
        Assert.assertEquals("Milka Leger", product1.getName());
        Assert.assertEquals("A01", product1.getCode());
        Assert.assertEquals(0.60, product1.getPrice(), 0.60);
        Assert.assertEquals(10, product1.getQuantity());
    }
}
