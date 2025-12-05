package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass;

import java.io.Serializable;
import java.util.Random;

public class SupplierOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderId;
    private String supplierId;
    private String productName;
    private int quantity;
    private String dueDate;

    // Constructor with auto-generated order ID
    public SupplierOrder(String supplierId, String productName, int quantity, String dueDate) {
        this.orderId = generateUniqueOrderId();
        this.supplierId = supplierId;
        this.productName = productName;
        this.quantity = quantity;
        this.dueDate = dueDate;
    }

    // Constructor with explicit order ID (optional)
    public SupplierOrder(String orderId, String supplierId, String productName, int quantity, String dueDate) {
        this.orderId = orderId;
        this.supplierId = supplierId;
        this.productName = productName;
        this.quantity = quantity;
        this.dueDate = dueDate;
    }

    // Getters and setters
    public String getOrderId() {
        return orderId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "SupplierOrder{" +
                "orderId='" + orderId + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }

    // Helper method to generate a unique order ID
    private String generateUniqueOrderId() {
        long timestamp = System.currentTimeMillis(); // current time in milliseconds
        int randomNumber = new Random().nextInt(900) + 100; // random 3-digit number (100-999)
        return "ORD" + timestamp + randomNumber;
    }
}
