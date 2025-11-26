package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MembershipController extends BaseController {
    @javafx.fxml.FXML
    private TextField txtPhone;
    @javafx.fxml.FXML
    private TextField txtUsername;
    @javafx.fxml.FXML
    private TextField txtFullName;
    @javafx.fxml.FXML
    private TextField txtEmail;
    @javafx.fxml.FXML
    private TextField txtMembershipType;

    @javafx.fxml.FXML
    public void handleRegister(ActionEvent actionEvent) {
    }
}
