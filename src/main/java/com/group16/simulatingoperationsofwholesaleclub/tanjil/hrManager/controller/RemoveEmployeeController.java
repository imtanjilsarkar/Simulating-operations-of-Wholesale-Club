package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RemoveEmployeeController extends BaseController {
    @javafx.fxml.FXML
    private TableColumn colName;
    @javafx.fxml.FXML
    private TableView employeeTable;
    @javafx.fxml.FXML
    private TableColumn colAction;
    @javafx.fxml.FXML
    private TextField txtSearch;
    @javafx.fxml.FXML
    private TableColumn colID;
    @javafx.fxml.FXML
    private TableColumn colPosition;
    @javafx.fxml.FXML
    private TableColumn colDepartment;

    @javafx.fxml.FXML
    public void handleSearch(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleRemoveEmployee(ActionEvent actionEvent) {
    }

}
