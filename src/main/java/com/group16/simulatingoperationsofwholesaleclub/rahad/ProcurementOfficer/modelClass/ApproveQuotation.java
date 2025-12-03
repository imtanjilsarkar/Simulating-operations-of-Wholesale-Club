package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass;

import java.io.Serializable;
import java.time.LocalDateTime;


public class ApproveQuotation implements Serializable {
    private static final long serialVersionUID = 1L;

    private String supplierName;
    private String productName;
    private double price;
    private String qualityNotes;

    @Override
    public String toString() {
        return "ApproveQuotation{" +
                "supplierName='" + supplierName + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", qualityNotes='" + qualityNotes + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getQualityNotes() {
        return qualityNotes;
    }

    public void setQualityNotes(String qualityNotes) {
        this.qualityNotes = qualityNotes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;


    public ApproveQuotation(String supplierName, String productName, double price, String qualityNotes, String status) {
        this.supplierName = supplierName;
        this.productName = productName;
        this.price = price;
        this.qualityNotes = qualityNotes;
        this.status = status;

    }
}