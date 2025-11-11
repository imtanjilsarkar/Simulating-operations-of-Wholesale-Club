package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HRReportController {
    @javafx.fxml.FXML
    private TableView reportTable;
    @javafx.fxml.FXML
    private TableColumn payrollColumn;
    @javafx.fxml.FXML
    private TableColumn attendanceColumn;
    @javafx.fxml.FXML
    private TableColumn employeeColumn;
    @javafx.fxml.FXML
    private TableColumn departmentColumn;
    @javafx.fxml.FXML
    private TableColumn shiftColumn;
    @javafx.fxml.FXML
    private TableColumn leaveColumn;

    @javafx.fxml.FXML
    public void handleRefreshReport(ActionEvent actionEvent) {
    }
    //generate HR summary report
}
