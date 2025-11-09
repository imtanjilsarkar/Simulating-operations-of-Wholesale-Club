package project.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    //approve/reject leave requests
}
