package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReviewPurchaseRequestController {

    @FXML
    private Button showRequestsButton;

    @FXML
    private TextArea requestsTextArea;

    private static final String FILE_PATH =
            "C:\\Users\\MUBASSIR_MOHI\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\purchase_requests.txt";

    @FXML
    public void showApprovedRequests(ActionEvent event) {
        requestsTextArea.clear();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            requestsTextArea.setText("Purchase requests file not found.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Store Manager-Approved Purchase Requests:\n\n");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming format: RequestID,Product,Quantity
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    sb.append("Request ID: ").append(parts[0].trim())
                            .append(", Product: ").append(parts[1].trim())
                            .append(", Quantity: ").append(parts[2].trim())
                            .append("\n");
                }
            }
            requestsTextArea.setText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
            requestsTextArea.setText("Error reading purchase requests.");
        }
    }

    @FXML
    public void handleBack(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/procurementOff_dashboard.fxml",
                event
        );
    }
}
