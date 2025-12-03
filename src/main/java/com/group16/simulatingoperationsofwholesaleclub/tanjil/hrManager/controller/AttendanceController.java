package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.modelClass.Attendance;
import com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.modelClass.Employee;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendanceController extends BaseController {
    @javafx.fxml.FXML
    private TableView <Attendance> attendanceTable;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colName;
    @javafx.fxml.FXML
    private TableColumn <Attendance, String> colAttendanceEmployee;
    @javafx.fxml.FXML
    private Label outputMessage;
    @javafx.fxml.FXML
    private TableView <Employee> employeeTable;
    @javafx.fxml.FXML
    private TableColumn <Attendance, String> colAttendanceDate;
    @javafx.fxml.FXML
    private ComboBox <String> cmbStatus;
    @javafx.fxml.FXML
    private TableColumn <Attendance, String> colAttendanceStatus;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colPosition;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colDepartment;

    List<Employee> employeeList = new ArrayList<>();
    List<Attendance> attendanceList = new ArrayList<>();

    public void initialize() {
        // Employee Table columns
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));

        // Attendance Table columns
        colAttendanceEmployee.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        colAttendanceDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colAttendanceStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        cmbStatus.getItems().addAll("Present", "Absent", "Leave");
    }


    @javafx.fxml.FXML
    public void handleMarkAttendance(ActionEvent actionEvent) {
        Employee selected = employeeTable.getSelectionModel().getSelectedItem();
        String status = cmbStatus.getValue();

        if (selected == null) {
            outputMessage.setText("Select an employee first.");
            return;
        }
        if (status == null) {
            outputMessage.setText("Select attendance status.");
            return;
        }

        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Attendance attendance = new Attendance(selected.getName(), today, status);
        attendanceList.add(attendance);
        attendanceTable.setItems(FXCollections.observableArrayList(attendanceList));
        outputMessage.setText("Attendance marked for " + selected.getName());
        cmbStatus.getSelectionModel().clearSelection();
    }

    @javafx.fxml.FXML
    public void handleClearAttendance(ActionEvent actionEvent) {
        attendanceTable.getItems().clear();
        attendanceList.clear();
        outputMessage.setText("Attendance table cleared.");
    }

    @javafx.fxml.FXML
    public void handleSaveAttendance(ActionEvent actionEvent) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("attendance.bin"))) {
            out.writeObject(attendanceList);
            outputMessage.setText("Attendance saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            outputMessage.setText("Error saving attendance.");
        }
    }

    @javafx.fxml.FXML
    public void handleLoadEmployees(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.bin"))) {
            employeeList = (List<Employee>) in.readObject();
            employeeTable.setItems(FXCollections.observableArrayList(employeeList));
            outputMessage.setText("Employees loaded successfully!");
        } catch (FileNotFoundException e) {
            outputMessage.setText("No employee file found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            outputMessage.setText("Error loading employees.");
        }
    }

}
