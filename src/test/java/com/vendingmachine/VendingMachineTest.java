package com.vendingmachine;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineTest {
    @Test
    public void vendingMachineCreated() {
        List<Stock> items = new ArrayList<Stock>();
        items.add(new Stock("Milka Leger", "A01", 0.60, 10));
        items.add(new Stock("Coca Cola Zero", "A02", 0.50, 5));
        items.add(new Stock("Snickers", "A03", 0.35, 2));
        items.add(new Stock("Orange Juice", "A04", 0.40, 1));
        VendingMachine machine = new VendingMachine(items, 100.00);

        Assert.assertEquals(items, machine.getItems());
        Assert.assertEquals(100.00, machine.getMoney(), 0.001);
    }

    @Test
    public void vendHandlesNotEnoughMoney() {
        List<Stock> items = new ArrayList<Stock>();
        items.add(new Stock("Milka Leger", "A01", 0.60, 10));
        VendingMachine machine = new VendingMachine(items, 100.00);
        String result = machine.vend("A01", 0.40);
        Assert.assertEquals("Not enough money!", result);
    }

    @Test
    public void vendHandlesOutOfStock() {
        List<Stock> items = new ArrayList<Stock>();
        items.add(new Stock("Milka Leger", "A01", 0.60, 0));
        VendingMachine machine = new VendingMachine(items, 100.00);
        String result = machine.vend("A01", 0.60);
        Assert.assertEquals("Milka Leger: Out of stock!", result);
    }

    @Test
    public void vendReturnsInvalidSelection() {
        List<Stock> items = new ArrayList<Stock>();
        items.add(new Stock("Milka Leger", "A01", 0.60, 10));
        VendingMachine machine = new VendingMachine(items, 100.0);
        String result = machine.vend("A02", 0.80);
        Assert.assertEquals("Invalid selection! : Money in vending machine = 100.00", result);
    }

    @Test
    public void vendUpdatesItemQuantity() {
        List<Stock> items = new ArrayList<Stock>();
        items.add(new Stock("Milka Leger", "A01", 0.60, 10));
        VendingMachine machine = new VendingMachine(items, 100.0);
        machine.vend("A01", 0.60);
        List<Stock> updatedItems = machine.getItems();
        Assert.assertEquals(9, updatedItems.get(0).getQuantity());
        machine.vend("A01", 0.80);
        Assert.assertEquals(8, items.get(0).getQuantity());
    }

    @Test
    public void vendReturnsItem() {
        List<Stock> items = new ArrayList<Stock>();
        items.add(new Stock("Milka Leger", "A01", 0.60, 10));
        VendingMachine machine = new VendingMachine(items, 100.00);
        String result = machine.vend("A01", 0.60);
        Assert.assertEquals("Vending Milka Leger", result);
    }

    @Test
    public void vendReturnsItemWithChange() {
        List<Stock> items = new ArrayList<Stock>();
        items.add(new Stock("Milka Leger", "A01", 0.60, 10));
        items.add(new Stock("Coca Cola Zero", "A02", 1.50, 10));
        VendingMachine machine = new VendingMachine(items, 100.00);
        String result = machine.vend("A01", 0.80);
        String result2 = machine.vend("A02", 2.50);
        Assert.assertEquals("Vending Milka Leger with 0.20 change", result);
        Assert.assertEquals("Vending Coca Cola Zero with 1.00 change", result2);
    }

    @Test
    public void vendUpdatesMoneyAfterSale() {
        List<Stock> items = new ArrayList<Stock>();
        items.add(new Stock("Milka Leger", "A01", 0.60, 10));
        VendingMachine machine = new VendingMachine(items, 100.00);
        machine.vend("A01", 0.60);
        double money = machine.getMoney();
        Assert.assertEquals(100.60, money, 0.001);
    }
}