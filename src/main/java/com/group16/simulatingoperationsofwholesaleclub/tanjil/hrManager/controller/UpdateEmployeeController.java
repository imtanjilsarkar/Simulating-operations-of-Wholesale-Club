package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.modelClass.Employee;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateEmployeeController extends BaseController {

    @javafx.fxml.FXML
    private ComboBox <String> cmbDepartment;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colName;
    @javafx.fxml.FXML
    private Label outputMessage;
    @javafx.fxml.FXML
    private ComboBox <String> cmbPosition;
    @javafx.fxml.FXML
    private TableView <Employee> employeeTable;
    @javafx.fxml.FXML
    private TextField txtSearchName;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colId;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colPosition;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colDepartment;

    List<Employee> employeeList = new ArrayList<>();
    Employee selectedEmployee = null;

    public void initialize() {
        cmbDepartment.getItems().addAll("Store Operations", "Inventory & Procurement", "Membership Services", "Delivery & Logistics", "Human Resources", "Customer Service");
        cmbPosition.getItems().addAll("Cashier", "Store Manager", "Inventory Manager", "Procurement Officer", "Membership Manager", "Delivery Coordinator", "HR Manager", "Customer Support Staff");

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
    }

    @javafx.fxml.FXML
    public void handleSearch(ActionEvent actionEvent) {
        String name = txtSearchName.getText().trim().toLowerCase();
        if (name.isEmpty()) {
            outputMessage.setText("Enter a name to search.");
            return;
        }
        for (Employee emp : employeeList) {
            if (emp.getName().toLowerCase().equals(name)) {
                selectedEmployee = emp;
                cmbDepartment.setValue(emp.getDepartment());
                cmbPosition.setValue(emp.getPosition());
                outputMessage.setText("Employee found: " + emp.getName());
                return;
            }
        }
        outputMessage.setText("Employee not found.");
    }


    @javafx.fxml.FXML
    public void handleClearForm(ActionEvent actionEvent) {
        txtSearchName.clear();
        cmbDepartment.getSelectionModel().clearSelection();
        cmbPosition.getSelectionModel().clearSelection();
        selectedEmployee = null;
        outputMessage.setText("");
    }



    @javafx.fxml.FXML
    public void handleUpdate(ActionEvent actionEvent) {
        if (selectedEmployee == null) {
            outputMessage.setText("Search and select an employee first.");
            return;
        }
        String newDept = cmbDepartment.getValue();
        String newPos = cmbPosition.getValue();

        if (newDept == null || newPos == null) {
            outputMessage.setText("Select department and position.");
            return;
        }

        selectedEmployee.setDepartment(newDept);
        selectedEmployee.setPosition(newPos);
        employeeTable.setItems(FXCollections.observableArrayList(employeeList));
        saveEmployeesToFile();
        outputMessage.setText("Employee updated successfully!");
        selectedEmployee = null;
        txtSearchName.clear();
        cmbDepartment.getSelectionModel().clearSelection();
        cmbPosition.getSelectionModel().clearSelection();
    }



    private void saveEmployeesToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.bin"))) {
            out.writeObject(employeeList);
        } catch (IOException e) {
            outputMessage.setText("Error saving employee data.");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void handleLoadEmployees(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.bin"))) {
            employeeList = (List<Employee>) in.readObject();
            employeeTable.setItems(FXCollections.observableArrayList(employeeList));
            outputMessage.setText("Employees loaded.");
        } catch (FileNotFoundException e) {
            outputMessage.setText("No employee file found.");
        } catch (IOException | ClassNotFoundException e) {
            outputMessage.setText("Error loading employees.");
            e.printStackTrace();
        }
    }
}
