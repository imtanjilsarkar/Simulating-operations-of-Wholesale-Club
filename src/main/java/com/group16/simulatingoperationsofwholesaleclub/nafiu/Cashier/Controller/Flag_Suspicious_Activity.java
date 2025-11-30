package com.group16.simulatingoperationsofwholesaleclub.nafiu.Cashier.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class Flag_Suspicious_Activity {
    @javafx.fxml.FXML
    private Label recordStatusLabel;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private TextArea reasonField;

    @javafx.fxml.FXML
    public void handleSubmitReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleReportTransaction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/Nafiu/Cashier/cashier_dashboard.fxml",actionEvent);
    }
}
