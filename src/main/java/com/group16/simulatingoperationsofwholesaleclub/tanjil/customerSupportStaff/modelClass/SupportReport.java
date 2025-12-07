package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.modelClass;

public class SupportReport {
    private String customerName;
    private String complaintTitle;
    private String status;// Solved / Unsolved / Updated
    private String date;

    public SupportReport(String customerName,String complaintTitle, String status, String date) {
        this.customerName = customerName;
        this.status = status;
        this.date = date;
        this.complaintTitle = complaintTitle;
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

    @Override
    public String toString() {
        return "SupportReport{" +
                "customerName='" + customerName + '\'' +
                ", complaintTitle='" + complaintTitle + '\'' +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
