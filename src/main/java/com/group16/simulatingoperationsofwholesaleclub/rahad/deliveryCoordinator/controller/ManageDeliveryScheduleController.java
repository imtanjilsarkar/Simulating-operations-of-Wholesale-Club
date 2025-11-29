package com.group16.simulatingoperationsofwholesaleclub.rahad.deliveryCoordinator.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManageDeliveryScheduleController {
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableColumn colTime;
    @javafx.fxml.FXML
    private TableColumn colDriver;
    @javafx.fxml.FXML
    private TableView scheduleTable;
    @javafx.fxml.FXML
    private TableColumn colDate;
    @javafx.fxml.FXML
    private TableColumn colOrderID;

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
    }

    @Deprecated
    public void saveScheduleBTN(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ViewScheduleBTN(ActionEvent actionEvent) {
    }
}
