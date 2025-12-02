package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.modelClass;

import java.time.LocalDate; // Import the necessary class

public class StaffTask {
    private String staffId;
    private LocalDate date;
    private String task;


    @Override
    public String toString() {

        return staffId + "|" + date.toString() + "|" + task;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public StaffTask(String staffId, LocalDate date, String task) {
        this.staffId = staffId;
        this.date = date;
        this.task = task;
    }
}