package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.modelClass;

public class PromotionRequest {
    private String title;
    private String details;
    private String status;

    @Override
    public String toString() {
        return "PromotionRequest{" +
                "title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public PromotionRequest(String title, String details, String status) {
        this.title = title;
        this.details = details;
        this.status = status;
    }
}
