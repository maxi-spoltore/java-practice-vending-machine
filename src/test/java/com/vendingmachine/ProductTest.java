package com.vendingmachine;

import org.junit.Assert;
import org.junit.Test;

public class ProductTest {

    @Test
    public void productIsCreated() {
        Product chocolate = new Product("Milka Leger", 0.60);
        Assert.assertEquals("Milka Leger", chocolate.getName());
        Assert.assertEquals(0.60, chocolate.getPrice(), 0.60);
    }
}
