package com.aor.refactoring.example1;

public class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public String getInfo() {
        return getProduct().getName() + "(x" + getQuantity() + "): " + (getProduct().getPrice() * getQuantity()) + "\n";
    }
}
