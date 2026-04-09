package com.mycompany.onlineordersystem;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class Invoice {
    private int invoiceId;
    private Customer customer;
    private Order order;
    private LocalDate date;

    public Invoice(Customer customer, Order order) {
        this.customer = customer;
        this.order = order;
        this.date = LocalDate.now();
        this.invoiceId = new Random().nextInt(10000);
    }

    public String generateInvoiceText() {
        StringBuilder sb = new StringBuilder();

        sb.append("===== INVOICE =====\n");
        sb.append("Invoice ID: ").append(invoiceId).append("\n");
        sb.append("Date: ").append(date).append("\n");
        sb.append("Customer: ").append(customer.getName()).append("\n\n");

        sb.append("Product\tQty\tPrice\tTotal\n");

        for (Product p : order.getProducts()) {
            sb.append(p.getName()).append("\t")
           .append(p.getQuantity()).append("\t")
           .append("$").append(p.getPrice()).append("\t")
           .append("$").append(p.getTotal()).append("\n");
}

        sb.append("\nGrand Total: $").append(order.getGrandTotal()).append("\n");
        sb.append("===================\n");

        return sb.toString();
    }

    public void saveToFile(String content) {
        try {
            FileWriter writer = new FileWriter("invoice.txt");
            writer.write(content);
            writer.close();
            System.out.println("Invoice saved to invoice.txt");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
}