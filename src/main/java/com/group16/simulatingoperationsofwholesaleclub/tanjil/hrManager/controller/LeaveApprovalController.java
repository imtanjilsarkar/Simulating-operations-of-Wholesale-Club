package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.modelClass.LeaveRequest;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeaveApprovalController  extends BaseController {
    @javafx.fxml.FXML
    private TableView <LeaveRequest> leaveTable;
    @javafx.fxml.FXML
    private TableColumn <LeaveRequest, String> colStartDate;
    @javafx.fxml.FXML
    private TableColumn <LeaveRequest, String> colLeaveType;
    @javafx.fxml.FXML
    private TableColumn <LeaveRequest, String> colEndDate;
    @javafx.fxml.FXML
    private TableColumn <LeaveRequest, String> colStatus;
    @javafx.fxml.FXML
    private Label outputMessage;
    @javafx.fxml.FXML
    private TableColumn <LeaveRequest, String> colEmpName;

    List<LeaveRequest> leaveRequests = new ArrayList<>();
    LeaveRequest selectedRequest = null;

    public void initialize() {
        colEmpName.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        colLeaveType.setCellValueFactory(new PropertyValueFactory<>("leaveType"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        colEndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
    }


    @javafx.fxml.FXML
    public void handleReject(ActionEvent actionEvent) {
        selectedRequest = leaveTable.getSelectionModel().getSelectedItem();
        if (selectedRequest == null) {
            outputMessage.setText("Select a leave request to reject.");
            return;
        }
        selectedRequest.setStatus("Rejected");
        saveRequestsToFile();
        leaveTable.refresh();
        outputMessage.setText("Leave request rejected.");
    }

    private void saveRequestsToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("leaveRequests.bin"))) {
            out.writeObject(leaveRequests);
        } catch (IOException e) {
            outputMessage.setText("Error saving leave requests.");
            e.printStackTrace();
        }
    }




    @javafx.fxml.FXML
    public void handleApprove(ActionEvent actionEvent) {
        selectedRequest = leaveTable.getSelectionModel().getSelectedItem();
        if (selectedRequest == null) {
            outputMessage.setText("Select a leave request to approve.");
            return;
        }
        selectedRequest.setStatus("Approved");
        saveRequestsToFile();
        leaveTable.refresh();
        outputMessage.setText("Leave request approved.");
    }



    @javafx.fxml.FXML
    public void handleLoadRequests(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("leaveRequests.bin"))) {
            leaveRequests = (List<LeaveRequest>) in.readObject();
            leaveTable.setItems(FXCollections.observableArrayList(leaveRequests));
            outputMessage.setText("Leave requests loaded.");
        } catch (Exception e) {
            outputMessage.setText("No leave requests found.");
        }
    }
}
