package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class deliveryCoordinatorDashboardController {
    @Deprecated
    public void handleReportDeliveryProblems(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleLogout(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleConfirmCompletedDeliveries(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleTrackDelivery(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleConfirmDelivery(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleReturnedOrders(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleDeliverySchedule(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/manage_schedule.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleRequestReDelivery(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleAssignTasks(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleReportProblems(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleDeliveryReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
    }
}
