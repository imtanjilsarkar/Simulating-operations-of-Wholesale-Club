package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class GenerateDeliveryReportController {
    @javafx.fxml.FXML
    private TableView reportTable;
    @javafx.fxml.FXML
    private TableColumn colTime;
    @javafx.fxml.FXML
    private TableColumn colDriver;
    @javafx.fxml.FXML
    private TableColumn colDate;
    @javafx.fxml.FXML
    private TableColumn colOrderID;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleGenerateReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleDownloadReport(ActionEvent actionEvent) {
    }
}
