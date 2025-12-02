package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.modelClass.Employee;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecruitmentController extends BaseController {
    @javafx.fxml.FXML
    private TextField txtPhone;
    @javafx.fxml.FXML
    private TextField txtFullName;
    @javafx.fxml.FXML
    private TextField txtEmail;
    @javafx.fxml.FXML
    private ComboBox <String> cmbDepartment;
    @javafx.fxml.FXML
    private ComboBox <String> cmbPosition;
    @javafx.fxml.FXML
    private Label outputMessage;

    List<Employee> employeeList = new ArrayList<>();

    @javafx.fxml.FXML    public void initialize() {
        cmbDepartment.getItems().addAll(
                "Store Operations", "Inventory & Procurement", "Membership Services", "Delivery & Logistics", "Human Resources", "Customer Service");
        cmbPosition.getItems().addAll(
                "Cashier", "Store Manager", "Inventory Manager", "Procurement Officer", "Membership Manager", "Delivery Coordinator", "HR Manager", "Customer Support Staff");
    }

    @javafx.fxml.FXML
    public void handleClearForm(ActionEvent actionEvent) {
        txtFullName.clear();
        txtEmail.clear();
        txtPhone.clear();
        cmbDepartment.getSelectionModel().clearSelection();
        cmbPosition.getSelectionModel().clearSelection();
    }

    @javafx.fxml.FXML
    public void handleAddEmployee(ActionEvent actionEvent) {
        String fullName = txtFullName.getText().trim();
        String email = txtEmail.getText().trim();
        String phone = txtPhone.getText().trim();
        String department = cmbDepartment.getValue();
        String position = cmbPosition.getValue();

        if(fullName.isEmpty() || email.isEmpty() || phone.isEmpty() || department == null || position == null){
            outputMessage.setText("Please fill in all fields.");
            return;
        }

        Employee emp = new Employee(fullName, department, position); // keep your model as-is
        employeeList.add(emp);

        outputMessage.setText("Employee added successfully!");
        handleClearForm(actionEvent);
        }

    @javafx.fxml.FXML
    public void handleSaveToFile(ActionEvent actionEvent) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.bin"))) {
            out.writeObject(employeeList);
            outputMessage.setText("Employee data saved to employee.bin");
        } catch (IOException e) {
            e.printStackTrace();
            outputMessage.setText("Something went wrong while saving!");
        }
    }
}



