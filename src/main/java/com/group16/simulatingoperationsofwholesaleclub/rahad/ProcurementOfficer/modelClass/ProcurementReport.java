package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass;

import javafx.beans.property.*;

public class ProcurementReport {


    private final StringProperty supplierName;
    private final StringProperty productName;
    private final IntegerProperty quantity;
    private final DoubleProperty unitCost;
    private final StringProperty status;


    public ProcurementReport(String supplierName, String productName, int quantity, double unitCost, String status) {
        this.supplierName = new SimpleStringProperty(supplierName);
        this.productName = new SimpleStringProperty(productName);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.unitCost = new SimpleDoubleProperty(unitCost);
        this.status = new SimpleStringProperty(status);
    }


    public String getSupplierName() { return supplierName.get(); }
    public String getProductName() { return productName.get(); }
    public int getQuantity() { return quantity.get(); }
    public double getUnitCost() { return unitCost.get(); }
    public String getStatus() { return status.get(); }


    public StringProperty supplierNameProperty() { return supplierName; }
    public StringProperty productNameProperty() { return productName; }
    public IntegerProperty quantityProperty() { return quantity; }
    public DoubleProperty unitCostProperty() { return unitCost; }
    public StringProperty statusProperty() { return status; }

    // Helper to calculate total line cost
    public double getTotalLineCost() {
        return getQuantity() * getUnitCost();
    }
}