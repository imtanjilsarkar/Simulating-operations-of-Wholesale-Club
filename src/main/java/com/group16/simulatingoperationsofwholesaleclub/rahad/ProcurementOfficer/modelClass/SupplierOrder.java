package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass;

public class SupplierOrder {
    private String supplierId;
    private String productName;
    private int quantity;
    private String dueDate;

    @Override
    public String toString() {
        return "SupplierOrder{" +
                "supplierId='" + supplierId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", dueDate='" + dueDate + '\'' +
                '}';
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

    public SupplierOrder(String supplierId, String productName, int quantity, String dueDate) {
        this.supplierId = supplierId;
        this.productName = productName;
        this.quantity = quantity;
        this.dueDate = dueDate;
    }
}
