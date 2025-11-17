package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class LeaveApprovalController {
    @javafx.fxml.FXML
    private TableView leaveTable;
    @javafx.fxml.FXML
    private TableColumn colEmployeeName;
    @javafx.fxml.FXML
    private TableColumn colStartDate;
    @javafx.fxml.FXML
    private TableColumn colAction;
    @javafx.fxml.FXML
    private TableColumn colLeaveType;
    @javafx.fxml.FXML
    private TableColumn colEndDate;
    @javafx.fxml.FXML
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void handleReject(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleApprove(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/hrManager/hr_manager_dashboard.fxml", actionEvent);
    }
    //approve/reject leave requests
}
