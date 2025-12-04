package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass;

import java.io.Serializable;

public class ReDeliveryRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orderId;
    private String reason;

    public ReDeliveryRequest(String orderId, String reason) {
        this.orderId = orderId;
        this.reason = reason;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getReason() {
        return reason;
    }
}
