package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class SupportReportController {
    @javafx.fxml.FXML
    private TableColumn colReportID;
    @javafx.fxml.FXML
    private TableColumn colCustomerName;
    @javafx.fxml.FXML
    private TableColumn colComplaintType;
    @javafx.fxml.FXML
    private TableColumn colDate;
    @javafx.fxml.FXML
    private TableColumn colRemarks;
    @javafx.fxml.FXML
    private TableView tblReports;
    @javafx.fxml.FXML
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void handleRefresh(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/customerSupportStaff/support_dashboard.fxml", actionEvent);
    }
    //generate support report
    //nhdjafdnh
}
