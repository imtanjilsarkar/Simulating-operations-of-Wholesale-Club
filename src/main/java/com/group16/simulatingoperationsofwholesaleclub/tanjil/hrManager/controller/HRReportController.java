package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.modelClass.Employee;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import org.w3c.dom.Document;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HRReportController extends BaseController {
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colName;
    @javafx.fxml.FXML
    private Button btnExportPDF;
    @javafx.fxml.FXML
    private Label outputMessage;
    @javafx.fxml.FXML
    private TableView <Employee> employeeTable;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colId;
    @javafx.fxml.FXML
    private TableColumn <Employee, Double> colSalary;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colPosition;
    @javafx.fxml.FXML
    private Button btnLoadReport;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colDepartment;

    List<Employee> employeeList = new ArrayList<>();

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
    }


    @javafx.fxml.FXML
    public void exportToPDF(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleLoadReport(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.bin"))) {
            employeeList = (List<Employee>) in.readObject();
            employeeTable.setItems(FXCollections.observableArrayList(employeeList));
            outputMessage.setText("HR Report loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            outputMessage.setText("Could not load employee data.");
            e.printStackTrace();
        }
    }


}
