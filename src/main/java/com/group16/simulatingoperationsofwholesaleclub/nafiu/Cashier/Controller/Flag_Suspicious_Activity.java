package com.group16.simulatingoperationsofwholesaleclub.nafiu.Cashier.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.BufferedWriter;
import java.io.FileWriter;
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

        String reason = reasonField.getText().trim();

        if (reason.isEmpty()) {
            confirmationLabel.setText("Please enter a reason");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("suspiciousactivity.txt", true))) {
            writer.write(reason);
            writer.newLine();

            recordStatusLabel.setText("Record Saved");
            confirmationLabel.setText("Manager Notified");
        } catch (IOException e) {
            confirmationLabel.setText("Error saving report");
            e.printStackTrace();
        }
        reasonField.clear();
    }
    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/cashier_dashboard.fxml", actionEvent);
    }
}
