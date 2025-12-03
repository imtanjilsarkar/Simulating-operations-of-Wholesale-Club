package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.modelClass.PurchaseRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileWriter;
import java.io.IOException;

public class ApprovePurchaseController {

    @FXML
    private TextArea requestDetailsTF;

    @FXML
    private TextField requestIdTF;

    @FXML
    private Label messageLabel;

    private final String FILE_PATH =
            "C:/Users/MUBASSIR_MOHI/IdeaProjects/Simulating-operations-of-Wholesale-Club/purchase_requests.txt";

    @FXML
    public void backBTN(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo(
                    "/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/storemanager_dashboard.fxml",
                    actionEvent
            );
        } catch (IOException e) {
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Error returning to dashboard.");
        }
    }

    @FXML
    public void approveRequest(ActionEvent actionEvent) {
        saveRequest("Approved");
    }

    @FXML
    public void rejectRequest(ActionEvent actionEvent) {
        saveRequest("Rejected");
    }

    private void saveRequest(String status) {
        String requestId = requestIdTF.getText().trim();
        String details = requestDetailsTF.getText().trim();

        if (requestId.isEmpty() || details.isEmpty()) {
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Please enter both Request ID and Details.");
            return;
        }

        PurchaseRequest request = new PurchaseRequest(requestId, details, status, "");

        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(request.getRequestId() + "," +
                    request.getDetails() + "," +
                    request.getStatus() + "\n");

            messageLabel.setStyle("-fx-text-fill: green;");
            messageLabel.setText("Request " + status.toLowerCase() + " successfully.");

            requestIdTF.clear();
            requestDetailsTF.clear();

        } catch (IOException e) {
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Error saving request.");
        }
    }
}
