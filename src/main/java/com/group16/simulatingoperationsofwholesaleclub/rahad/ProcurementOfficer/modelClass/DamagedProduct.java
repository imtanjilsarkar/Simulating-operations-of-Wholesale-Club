package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass;

public class DamagedProduct {
    private String productId;
    private String productName;
    private int deductedQty;
    private String reason;


    public DamagedProduct(String productId, String productName, int deductedQty, String reason) {
        this.productId = productId;
        this.productName = productName;
        this.deductedQty = deductedQty;
        this.reason = reason;
    }


    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getDeductedQty() { return deductedQty; }
    public String getReason() { return reason; }


    public void setProductId(String productId) { this.productId = productId; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setDeductedQty(int deductedQty) { this.deductedQty = deductedQty; }
    public void setReason(String reason) { this.reason = reason; }
}
