package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass;

public class PendingDelivery {
    private String deliveryID;
    private String supplierName;
    private String productName;
    private String dueDate;
    private boolean isDelayed;

    @Override
    public String toString() {
        return "PendingDelivery{" +
                "deliveryID='" + deliveryID + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", productName='" + productName + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", isDelayed=" + isDelayed +
                '}';
    }

    public PendingDelivery(String deliveryID, String supplierName, String productName, String dueDate, boolean isDelayed) {
        this.deliveryID = deliveryID;
        this.supplierName = supplierName;
        this.productName = productName;
        this.dueDate = dueDate;
        this.isDelayed = isDelayed;
    }

    public String getDeliveryID() {
        return deliveryID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getProductName() {
        return productName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isDelayed() {
        return isDelayed;
    }


}
