package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass.ReturnProblem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class VerifyReturnedOrdersController {

    private static final String FILE_PATH_PROBLEMS =
            "C:\\Users\\rubay\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\return_problems.dat";

    @FXML
    private TextField orderIdField;

    @FXML
    private TextArea returnTextArea;

    @FXML
    private Label statusLabel;

    @FXML
    public void handleVerify(ActionEvent event) {
        String orderId = orderIdField.getText().trim();
        List<ReturnProblem> allProblems = readProblems();
        List<ReturnProblem> filtered = new ArrayList<>();

        // Filter by orderId if entered, otherwise show all
        for (ReturnProblem rp : allProblems) {
            if (orderId.isEmpty() || rp.getOrderId().equals(orderId)) {
                filtered.add(rp);
            }
        }

        if (filtered.isEmpty()) {
            statusLabel.setText("❌ No return problem found" + (orderId.isEmpty() ? "." : " for Order ID: " + orderId));
            returnTextArea.clear();
        } else {
            statusLabel.setText("✅ Return problem(s) found.");
            StringBuilder sb = new StringBuilder();
            for (ReturnProblem rp : filtered) {
                sb.append("Order ID: ").append(rp.getOrderId())
                        .append("\nReason: ").append(rp.getProblemDetails())
                        .append("\n----------------------\n");
            }
            returnTextArea.setText(sb.toString());
        }
    }

    @FXML
    public void handleBack(ActionEvent event) throws Exception {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/delivery_Dashboard.fxml",
                event
        );
    }

    // Helper to read return problems from file
    private List<ReturnProblem> readProblems() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH_PROBLEMS))) {
            return (List<ReturnProblem>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
