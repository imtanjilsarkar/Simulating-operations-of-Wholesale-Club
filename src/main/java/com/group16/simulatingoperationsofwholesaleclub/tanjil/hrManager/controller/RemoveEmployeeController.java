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
    private TableColumn <Employee, String> colName;
    @javafx.fxml.FXML
    private Label outputMessage;
    @javafx.fxml.FXML
    private TableView <Employee> employeeTable;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colId;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colPosition;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colDepartment;

    List<Employee> employeeList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
    }

    @javafx.fxml.FXML
    public void handleClearTable(ActionEvent actionEvent) {
        employeeTable.getItems().clear();
        outputMessage.setText("Table cleared.");
    }


    @javafx.fxml.FXML
    public void handleRemoveEmployee(ActionEvent actionEvent) {
        Employee selected = employeeTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            outputMessage.setText("Please select an employee to remove.");
            return;
        }

        employeeList.remove(selected);
        employeeTable.setItems(FXCollections.observableArrayList(employeeList));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.bin"))) {
            out.writeObject(employeeList);
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
            employeeList = (List<Employee>) in.readObject();
            employeeTable.setItems(FXCollections.observableArrayList(employeeList));
            outputMessage.setText("Employee list loaded successfully!");
        } catch (FileNotFoundException e) {
            employeeList = new ArrayList<>();
            employeeTable.setItems(FXCollections.observableArrayList());
            outputMessage.setText("No employees found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            outputMessage.setText("Error loading employees!");
        }
    }

}

