package com.mycompany.onlineordersystem;

import java.util.Scanner;

public class OnlineOrderSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Online Order Processing System ===");

        // Customer input
        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();
        Customer customer = new Customer(customerName);

        Order order = new Order();

        // Product input
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nProduct " + (i + 1));

            System.out.print("Product Name: ");
            String pname = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();

            Product product = new Product(pname, price, qty);
            order.addProduct(product);
        }

        // Generate Invoice
        Invoice invoice = new Invoice(customer, order);
        String invoiceText = invoice.generateInvoiceText();

        // Display
        System.out.println("\n" + invoiceText);

        // Save to file
        invoice.saveToFile(invoiceText);

        sc.close();
    }
}