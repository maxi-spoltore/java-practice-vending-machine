package com.vendingmachine;

import org.junit.Assert;
import org.junit.Test;

public class VendingMachineTest {
    @Test
    public void firstTest() {
        VendingMachine machine = new VendingMachine();
        int sum = machine.add(2, 2);
        Assert.assertEquals(4, sum);
    }
}