package com.vendingmachine;

public class Stock extends Product {
    private String code;
    private int quantity;

    public Stock(String name, String code, double price, int quantity) {
        super(name, price);
        this.code = code;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return super.toString() + "Stock{" +
                "code='" + code + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
