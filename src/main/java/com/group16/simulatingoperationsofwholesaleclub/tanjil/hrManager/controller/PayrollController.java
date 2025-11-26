package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class PayrollController extends BaseController {
    @javafx.fxml.FXML
    private TableColumn colNetPay;
    @javafx.fxml.FXML
    private TableView payrollTable;
    @javafx.fxml.FXML
    private TableColumn colEmployeeName;
    @javafx.fxml.FXML
    private TableColumn colSalary;
    @javafx.fxml.FXML
    private TableColumn colPosition;
    @javafx.fxml.FXML
    private TableColumn colDeductions;

    @javafx.fxml.FXML
    public void handleGeneratePayroll(ActionEvent actionEvent) {
    }

}
