package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VerifyReturnedOrdersController {
    @javafx.fxml.FXML
    private TableColumn colReason;
    @javafx.fxml.FXML
    private TableColumn colProduct;
    @javafx.fxml.FXML
    private TextField orderIdField;
    @javafx.fxml.FXML
    private TableView returnTable;
    @javafx.fxml.FXML
    private TableColumn colCustomer;
    @javafx.fxml.FXML
    private TableColumn colOrderID;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleVerify(ActionEvent actionEvent) {
    }
}
