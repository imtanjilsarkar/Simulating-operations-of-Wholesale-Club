package com.group16.simulatingoperationsofwholesaleclub.nafiu.Cashier.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class Cashier_Dashboard {
    @javafx.fxml.FXML
    public void handleSuspiciousActivity(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/flag_suspicious_activity.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleDailyReport(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/generate_daily_sales_report.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleQueueManagement(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/queue_management.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handlePayment(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/process_payment.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleMembershipDiscount(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/apply_membership_discount.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleLogout(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleCashDrawer(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/balance_cash_drawer.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleReturns(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/handle_returns_or_refunds.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleProcessCheckout(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/process_customer_checkout.fxml",actionEvent);
    }
}
