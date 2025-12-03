package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.modelClass.Employee;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PayrollController extends BaseController {
    @javafx.fxml.FXML
    private TableColumn <Employee, Double> colSalary;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colPosition;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colName;
    @javafx.fxml.FXML
    private Label outputMessage;
    @javafx.fxml.FXML
    private TableView <Employee> employeeTable;
    @javafx.fxml.FXML
    private TextField txtSalary;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colId;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colDepartment;

    List<Employee> employeeList = new ArrayList<>();
    Employee selectedEmployee = null;

    @javafx.fxml.FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        employeeTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedEmployee = newSelection;
                txtSalary.setText(String.valueOf(selectedEmployee.getSalary()));
            }
        });

    }



    @javafx.fxml.FXML
    public void handleUpdateSalary(ActionEvent actionEvent) {
        if (selectedEmployee == null) {
            outputMessage.setText("Select an employee first.");
            return;
        }

        try {
            double newSalary = Double.parseDouble(txtSalary.getText());


            for (Employee emp : employeeList) {
                if (emp.getId().equals(selectedEmployee.getId())) {
                    emp.setSalary(newSalary);
                    break;
                }
            }

            employeeTable.setItems(FXCollections.observableArrayList(employeeList));
            saveEmployeesToFile();
            outputMessage.setText("Salary updated successfully!");
            txtSalary.clear();
            selectedEmployee = null;
            employeeTable.getSelectionModel().clearSelection();

        } catch (NumberFormatException e) {
            outputMessage.setText("Enter a valid number for salary.");
        }
    }
        private void saveEmployeesToFile() {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.bin"))) {
                out.writeObject(employeeList);
            } catch (IOException e) {
                outputMessage.setText("Error saving employees.");
            }
        }


    @javafx.fxml.FXML
    public void handleLoadEmployees(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.bin"))) {
            employeeList = (List<Employee>) in.readObject();
            employeeTable.setItems(FXCollections.observableArrayList(employeeList));
            outputMessage.setText("Employees loaded.");
        } catch (Exception e) {
            outputMessage.setText("No employees found.");
        }
    }
}


