package com.group16.simulatingoperationsofwholesaleclub.nafiu.Cashier.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class Cashier_Dashboard {
    @javafx.fxml.FXML
    public void handleSuspiciousActivity(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/Nafiu/Cashier/flag_suspicious_activity.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleDailyReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleQueueManagement(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handlePayment(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleMembershipDiscount(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleLogout(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleCashDrawer(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleReturns(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleProcessCheckout(ActionEvent actionEvent) {
    }
}
