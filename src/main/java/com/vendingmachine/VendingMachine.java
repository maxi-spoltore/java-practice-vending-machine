package com.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Stock> items;
    private double money;

    public VendingMachine(List<Stock> items, double money) {
        this.items = items;
        this.money = money;
    }

    private Stock findItemByCode(List<Stock> items, String code) {
        for (Stock item : items) {
            if ( item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }

    public String vend(String code, double credit) {
        Stock item = findItemByCode(items, code);
        if (item == null) {
            return "Invalid selection! : Money in vending machine = " + String.format("%.2f", this.money);
        }
        String itemName = item.getName();

        double itemPrice = item.getPrice();
        if (itemPrice > credit) {
            return "Not enough money!";
        }
        int itemQuantity = item.getQuantity();
        if (itemQuantity == 0) {
            return itemName + ": Out of stock!";
        }

        int currentQuantity = item.getQuantity();
        item.setQuantity(currentQuantity - 1);
        return "Vending " + itemName;
    }

    public List<Stock> getItems() {
        return items;
    }

    public void setItems(List<Stock> items) {
        this.items = items;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "VendingMachine{" +
                "items=" + items +
                ", money=" + money +
                '}';
    }
}
