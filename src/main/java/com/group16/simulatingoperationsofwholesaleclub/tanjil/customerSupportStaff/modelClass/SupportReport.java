package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.modelClass;

public class SupportReport {
    private String customerName;
    private String complaintTitle;
    private String status;  // Solved / Unsolved / Updated

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SupportReport(String customerName, String complaintTitle, String status) {
        this.customerName = customerName;
        this.complaintTitle = complaintTitle;
        this.status = status;
    }

    @Override
    public String toString() {
        return "SupportReport{" +
                "customerName='" + customerName + '\'' +
                ", complaintTitle='" + complaintTitle + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
