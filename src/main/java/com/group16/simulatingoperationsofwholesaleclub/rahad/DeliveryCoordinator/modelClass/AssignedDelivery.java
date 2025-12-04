package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass;

import java.io.Serializable;

public class AssignedDelivery implements Serializable {

    private static final long serialVersionUID = 1L;

    private String staffId;
    private String orderId;       // Changed from deliveryNo to orderId
    private String deliveryDate;

    // Constructor
    public AssignedDelivery(String staffId, String orderId, String deliveryDate) {
        this.staffId = staffId;
        this.orderId = orderId;
        this.deliveryDate = deliveryDate;
    }

    // Getters and Setters
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    // toString method
    @Override
    public String toString() {
        return "AssignedDelivery{" +
                "staffId='" + staffId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                '}';
    }
}
