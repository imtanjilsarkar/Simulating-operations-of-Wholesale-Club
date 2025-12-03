package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.modelClass;

import java.io.Serializable;

public class Attendance implements Serializable {
    private String employeeName;
    private String date;
    private String status;

    public Attendance(String employeeName, String date, String status) {
        this.employeeName = employeeName;
        this.date = date;
        this.status = status;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "employeeName='" + employeeName + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
