package com.group16.simulatingoperationsofwholesaleclub.nafiu.Cashier.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;

public class Generate_Daily_Sales_Report {
    @javafx.fxml.FXML
    private Label reportStatusLabel;
    @javafx.fxml.FXML
    private Label netSalesLabel;
    @javafx.fxml.FXML
    private Label transactionDataLabel;

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/cashier_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleGenerateReport(ActionEvent actionEvent) {
        int totalTransactions = 5;
        int totalSales = 500;
        transactionDataLabel.setText("Total Transactions: " + totalTransactions);
        netSalesLabel.setText("Net Sales: " + totalSales + " taka");
        reportStatusLabel.setText("Report Generated Successfully");
    }
}
