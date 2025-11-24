package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UpdateEmployeeController {
    @javafx.fxml.FXML
    private TextField txtEmployeeID;
    @javafx.fxml.FXML
    private TextField txtContact;
    @javafx.fxml.FXML
    private TextField txtPosition;
    @javafx.fxml.FXML
    private TextField txtFullName;
    @javafx.fxml.FXML
    private TextField txtDepartment;

    @javafx.fxml.FXML
    public void handleUpdateEmployee(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSearchEmployee(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/hrManager/hr_manager_dashboard.fxml", actionEvent);
    }
    //update staff info
}
