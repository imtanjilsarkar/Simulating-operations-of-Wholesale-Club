package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.modelClass;

public class StaffComplaint {
    private String staffId;
    private String details;

    @Override
    public String toString() {
        return "StaffComplaint{" +
                "staffId='" + staffId + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStaffId() {
        return staffId;
    }


    public StaffComplaint(String staffId, String details) {
        this.staffId = staffId;
        this.details = details;
    }
}
