package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.modelClass;

public class Complaint {
    private String customerName;
    private String complaintTitle;
    private String description;

    public Complaint(String customerName, String complaintTitle, String description) {
        this.customerName = customerName;
        this.complaintTitle = complaintTitle;
        this.description = description;
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

    @Override
    public String toString() {
        return "Complaint{" +
                "customerName='" + customerName + '\'' +
                ", complaintTitle='" + complaintTitle + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
