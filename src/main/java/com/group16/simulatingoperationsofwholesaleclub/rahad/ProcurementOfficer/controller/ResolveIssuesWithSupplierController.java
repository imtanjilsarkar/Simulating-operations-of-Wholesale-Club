package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class ResolveIssuesWithSupplierController {
    @javafx.fxml.FXML
    private TableColumn colQuantity;
    @javafx.fxml.FXML
    private TableColumn colProductID;
    @javafx.fxml.FXML
    private TableView damagedTable;
    @javafx.fxml.FXML
    private TextArea remarksArea;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private TableColumn colProductName;

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/procurementOff_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void sendReplacementRequest(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadDamagedProducts(ActionEvent actionEvent) {
    }
}
