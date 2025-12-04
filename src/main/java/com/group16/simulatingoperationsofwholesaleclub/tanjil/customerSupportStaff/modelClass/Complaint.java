package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.modelClass;

public class Complaint {
    private String customerName;
    private String complaintTitle;
    private String description;
    private String status;

    public Complaint(String customerName, String complaintTitle, String description, String status) {
        this.customerName = customerName;
        this.complaintTitle = complaintTitle;
        this.description = description;
        this.status = status;
    }

    public Complaint(String customerName, String complaintTitle, String description) {
        this(customerName, complaintTitle, description, "Pending");
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getComplaintTitle() {
        return complaintTitle;
    }

    public void setComplaintTitle(String complaintTitle) {
        this.complaintTitle = complaintTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override   
    public String toString() {
        return customerName + " | " + complaintTitle + " | " + description + " | " + status;
    }
}
