package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.modelClass.Employee;
import com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.modelClass.LeaveRequest;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeaveRequestController extends BaseController {

    @javafx.fxml.FXML
    private DatePicker dpStart;
    @javafx.fxml.FXML
    private Label outputMessage;
    @javafx.fxml.FXML
    private TableView <LeaveRequest> leaveTable;
    @javafx.fxml.FXML
    private TableColumn <LeaveRequest, LocalDate> colStartDate;
    @javafx.fxml.FXML
    private DatePicker dpEnd;
    @javafx.fxml.FXML
    private TableColumn <LeaveRequest, String> colEmpName;
    @javafx.fxml.FXML
    private ComboBox <String> cmbLeaveType;
    @javafx.fxml.FXML
    private TableColumn <LeaveRequest, String> colLeaveType;
    @javafx.fxml.FXML
    private TableColumn <LeaveRequest, LocalDate> colEndDate;
    @javafx.fxml.FXML
    private TableColumn <LeaveRequest, String> colStatus;
    @javafx.fxml.FXML
    private TextField txtEmployeeName;


    List<Employee> employeeList = new ArrayList<>();
    List<LeaveRequest> leaveRequests = new ArrayList<>();


    public void initialize() {
        cmbLeaveType.getItems().addAll("Sick Leave", "Casual Leave", "Emergency Leave");

        colEmpName.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        colLeaveType.setCellValueFactory(new PropertyValueFactory<>("leaveType"));
        colStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        colEndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
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

    @javafx.fxml.FXML
    public void handleSubmitRequest(ActionEvent actionEvent) {
        String empName = txtEmployeeName.getText().trim();
        String type = cmbLeaveType.getValue();
        LocalDate start = dpStart.getValue();
        LocalDate end = dpEnd.getValue();

        if (empName.isEmpty() || type == null || start == null || end == null) {
            outputMessage.setText("Fill all fields before submitting.");
            return;
        }

        LeaveRequest request = new LeaveRequest(null, empName, type, start, end, "Pending");

        leaveRequests.add(request);
        saveRequestsToFile();

        leaveTable.setItems(FXCollections.observableArrayList(leaveRequests));
        outputMessage.setText("Leave request submitted!");

        txtEmployeeName.clear();
        cmbLeaveType.getSelectionModel().clearSelection();
        dpStart.setValue(null);
        dpEnd.setValue(null);
    }

    private void saveRequestsToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("leaveRequests.bin"))) {
            out.writeObject(leaveRequests);
        } catch (Exception e) {
            outputMessage.setText("Error saving request.");
        }
    }

    @javafx.fxml.FXML
    public void handleClearTable(ActionEvent actionEvent) {
        leaveTable.getItems().clear();
        outputMessage.setText("Table cleared.");
    }

}
