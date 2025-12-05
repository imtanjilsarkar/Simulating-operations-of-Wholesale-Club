package com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.modelClass;

import java.io.Serializable;

public class NewMembership implements Serializable {
    private static final long serialVersionUID = 1L;

    private int customerId;
    private String customerName;
    private String membershipType;
    private String validTill;

    public NewMembership(int customerId, String customerName, String membershipType, String validTill) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.membershipType = membershipType;
        this.validTill = validTill;
    }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }

    public String getValidTill() { return validTill; }
    public void setValidTill(String validTill) { this.validTill = validTill; }

    @Override
    public String toString() {
        return "NewMembership{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", membershipType='" + membershipType + '\'' +
                ", validTill='" + validTill + '\'' +
                '}';
    }
}
