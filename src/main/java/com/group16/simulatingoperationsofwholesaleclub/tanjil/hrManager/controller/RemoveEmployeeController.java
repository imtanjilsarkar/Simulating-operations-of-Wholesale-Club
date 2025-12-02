package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.modelClass.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveEmployeeController extends BaseController {
    @javafx.fxml.FXML
    private TableColumn<Employee, String> colName;
    @javafx.fxml.FXML
    private TableView<Employee> employeeTable;
    @javafx.fxml.FXML
    private TextField txtSearch;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> colPosition;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> colDepartment;
    @javafx.fxml.FXML
    private Label outputMessage;

    List<Employee> employeeList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));

        // Load all employees from file at start
        //loadEmployeesFromFile();
    }

    @javafx.fxml.FXML
    public void handleSearch(ActionEvent actionEvent) {

        String searchText = txtSearch.getText().trim();
        if (searchText.isEmpty()) {
            employeeTable.setItems(FXCollections.observableArrayList(employeeList));
            return;
        }
        List<Employee> filtered = employeeList.stream()
                .filter(e -> e.getName().toLowerCase().contains(searchText))
                .collect(Collectors.toList());

        employeeTable.setItems(FXCollections.observableArrayList(filtered));
    }

    @javafx.fxml.FXML
    public void handleRemoveEmployee(ActionEvent actionEvent) {
        Employee selected = employeeTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            outputMessage.setText("Please select an employee to remove.");
            return;
        }

        employeeList.remove(selected); // remove from List
        employeeTable.setItems(FXCollections.observableArrayList(employeeList)); // refresh table

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.bin"))) {
            out.writeObject(employeeList); // save updated list
        } catch (IOException e) {
            e.printStackTrace();
            outputMessage.setText("Error saving updated employee list.");
            return;
        }

        outputMessage.setText("Employee removed successfully!");
    }


    @javafx.fxml.FXML
    public void handleLoadEmployees(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.bin"))) {
            employeeList = (List<Employee>) in.readObject(); // load list
            employeeTable.setItems(FXCollections.observableArrayList(employeeList)); // refresh TableView
            outputMessage.setText("Employee list loaded successfully!");
        } catch (FileNotFoundException e) {
            employeeList = new ArrayList<>();
            employeeTable.setItems(FXCollections.observableArrayList(employeeList));
            outputMessage.setText("No employees found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            outputMessage.setText("Error loading employees!");
        }
    }
}
