package com.mycompany.onlineordersystem;
import java.util.ArrayList;

public class Order {
    private ArrayList<Product> products;

    public Order() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double getGrandTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getTotal();
        }
        return total;
    }
}