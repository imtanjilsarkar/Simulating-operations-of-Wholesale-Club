package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass;

import java.io.Serializable;

public class ConfirmOrders implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderId;
    private boolean delivered;

    public ConfirmOrders(String orderId, boolean delivered) {
        this.orderId = orderId;
        this.delivered = delivered;
    }

    public String getOrderId() {
        return orderId;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}
