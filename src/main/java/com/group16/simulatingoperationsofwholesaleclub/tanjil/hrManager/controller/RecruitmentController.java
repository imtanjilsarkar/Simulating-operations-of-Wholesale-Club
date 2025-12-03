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
import java.util.UUID;

public class RecruitmentController extends BaseController {
    @javafx.fxml.FXML
    private TextField txtFullName;
    @javafx.fxml.FXML
    private ComboBox<String> cmbDepartment;
    @javafx.fxml.FXML
    private ComboBox<String> cmbPosition;
    @javafx.fxml.FXML
    private Label outputMessage;

    List<Employee> employeeList = new ArrayList<>();

    public void initialize() {
        cmbDepartment.getItems().addAll("Store Operations", "Inventory & Procurement", "Membership Services", "Delivery & Logistics", "Human Resources", "Customer Service");

        cmbPosition.getItems().addAll("Cashier", "Store Manager", "Inventory Manager", "Procurement Officer", "Membership Manager", "Delivery Coordinator", "HR Manager", "Customer Support Staff");


    }

    @javafx.fxml.FXML
    public void handleClearForm(ActionEvent actionEvent) {
        txtFullName.clear();
        cmbDepartment.getSelectionModel().clearSelection();
        cmbPosition.getSelectionModel().clearSelection();
        outputMessage.setText("");
    }

    @javafx.fxml.FXML
    public void handleAddEmployee(ActionEvent actionEvent) {
        String fullName = txtFullName.getText().trim();
        String department = cmbDepartment.getValue();
        String position = cmbPosition.getValue();

        if (fullName.isEmpty() || department == null || position == null) {
            outputMessage.setText("Please fill in all fields.");
            return;
        }

        // Generate unique ID
        String id = UUID.randomUUID().toString();
        double initialSalary = 0.0;

        Employee emp = new Employee(id, fullName, department, position, initialSalary);
        employeeList.add(emp);

        outputMessage.setText("Employee added successfully!");
        handleClearForm(actionEvent);
    }


    @javafx.fxml.FXML
    public void handleSaveToFile(ActionEvent actionEvent) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.bin"))) {
            out.writeObject(employeeList);
            outputMessage.setText("Employee data saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            outputMessage.setText("Error saving employee data.");
        }
    }

}





