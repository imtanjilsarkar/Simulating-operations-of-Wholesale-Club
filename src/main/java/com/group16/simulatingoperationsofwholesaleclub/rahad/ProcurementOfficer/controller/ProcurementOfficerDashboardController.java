package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ProcurementOfficerDashboardController {
    @javafx.fxml.FXML
    public void createOrder(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/procurementOff_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void trackPendingDeliveries(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resolveIssues(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void contactSupplier(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void reviewRequests(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void manageRecords(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void approveQuotation(ActionEvent actionEvent) {
    }
}
