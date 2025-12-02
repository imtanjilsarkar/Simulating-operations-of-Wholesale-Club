package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class ViewSupplierContactsController
{
    @javafx.fxml.FXML
    private TableView supplierTable;
    @javafx.fxml.FXML
    private TableColumn suppName;
    @javafx.fxml.FXML
    private TableColumn suppPhone;
    @javafx.fxml.FXML
    private TableColumn suppaddress;
    @javafx.fxml.FXML
    private TableColumn suppID;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/procurementOff_dashboard.fxml",actionEvent);

    }

    @javafx.fxml.FXML
    public void loadContacts(ActionEvent actionEvent) {
    }
}