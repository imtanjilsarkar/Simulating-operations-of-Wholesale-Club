package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ReDeliveryRequestController
{
    @javafx.fxml.FXML
    private Label stockStatusLabel;
    @javafx.fxml.FXML
    private TextField orderIdField;
    @javafx.fxml.FXML
    private TextArea reasonField;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/delivery_Dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleSaveRequest(ActionEvent actionEvent) {
    }
}