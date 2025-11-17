package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class HRManagerDashboardController {
    @javafx.fxml.FXML
    public void handlePayroll(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSummaryReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleUpdateEmployee(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleRecruitment(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleAttendance(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleLeaveApproval(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleRemoveEmployee(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleLogout(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/initial.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleShift(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/dashboard.fxml", actionEvent);
    }
    //main HR dashboard
}
