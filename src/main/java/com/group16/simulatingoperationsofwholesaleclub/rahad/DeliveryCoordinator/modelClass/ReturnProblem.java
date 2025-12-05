package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass;

import java.io.Serializable;

public class ReturnProblem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderId;
    private String problemDetails;

    public ReturnProblem(String orderId, String problemDetails) {
        this.orderId = orderId;
        this.problemDetails = problemDetails;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProblemDetails() {
        return problemDetails;
    }

    public void setProblemDetails(String problemDetails) {
        this.problemDetails = problemDetails;
    }

    @Override
    public String toString() {
        return "DeliveryProblem{" +
                "orderId='" + orderId + '\'' +
                ", problemDetails='" + problemDetails + '\'' +
                '}';
    }
}
