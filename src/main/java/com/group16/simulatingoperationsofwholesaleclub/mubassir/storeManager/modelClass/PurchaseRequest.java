package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.modelClass;

public class PurchaseRequest {
    private String requestId;
    private String details;
    private String status;
    private String date;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PurchaseRequest(String requestId, String details, String status, String date) {
        this.requestId = requestId;
        this.details = details;
        this.status = status;
        this.date = date;
    }
}
