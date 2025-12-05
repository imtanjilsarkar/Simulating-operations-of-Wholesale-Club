package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass.ConfirmOrders;
import com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass.ReturnProblem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReportReturnedOrderProblemController {


    private static final String FILE_PATH_COMPLETED = "confirmed_orders.dat";
    private static final String FILE_PATH_PROBLEMS = "return_problems.dat";

    @FXML
    private TextField orderIdField;

    @FXML
    private TextArea problemDetailsTA;

    @FXML
    private Label statusLabel;

    @FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/delivery_Dashboard.fxml", actionEvent);
    }

    @FXML
    public void handleSubmitProblem(ActionEvent actionEvent) {

        String orderId = orderIdField.getText().trim();
        String problemDetails = problemDetailsTA.getText().trim();

        statusLabel.setText("");

        if (orderId.isEmpty() || problemDetails.isEmpty()) {
            statusLabel.setText(" Please enter both Order ID and Problem Details.");
            return;
        }


        if (!isOrderDelivered(orderId)) {
            statusLabel.setText("This order is NOT marked as delivered yet. Cannot report return problem.");
            return;
        }


        List<ReturnProblem> problems = readProblems();


        problems.add(new ReturnProblem(orderId, problemDetails));


        saveProblems(problems);


        statusLabel.setText(" Return problem reported successfully!");
        orderIdField.clear();
        problemDetailsTA.clear();
    }


    private boolean isOrderDelivered(String orderId) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH_COMPLETED))) {
            List<ConfirmOrders> confirmed = (List<ConfirmOrders>) ois.readObject();
            for (ConfirmOrders c : confirmed) {
                if (c.getOrderId().equals(orderId)) {
                    return true;
                }
            }
        } catch (Exception ignored) {}
        return false;
    }

    private List<ReturnProblem> readProblems() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH_PROBLEMS))) {
            return (List<ReturnProblem>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void saveProblems(List<ReturnProblem> problems) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH_PROBLEMS))) {
            oos.writeObject(problems);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
