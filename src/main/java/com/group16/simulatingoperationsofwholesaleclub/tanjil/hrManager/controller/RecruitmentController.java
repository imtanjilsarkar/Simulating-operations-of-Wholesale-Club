package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RecruitmentController {
    @javafx.fxml.FXML
    private TextField txtPhone;
    @javafx.fxml.FXML
    private TextField txtPosition;
    @javafx.fxml.FXML
    private Button btnAddEmployee;
    @javafx.fxml.FXML
    private TextField txtFullName;
    @javafx.fxml.FXML
    private TextField txtDepartment;
    @javafx.fxml.FXML
    private TextField txtEmail;
    @javafx.fxml.FXML
    private Button btnClear;

    @javafx.fxml.FXML
    public void handleClearForm(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleAddEmployee(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/hrManager/hr_manager_dashboard.fxml", actionEvent);
    }
    //handle recruit staff
}
