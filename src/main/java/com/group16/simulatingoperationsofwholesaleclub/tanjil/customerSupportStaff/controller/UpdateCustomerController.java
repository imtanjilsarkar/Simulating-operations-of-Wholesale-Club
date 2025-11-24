package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UpdateCustomerController {
    @javafx.fxml.FXML
    private TextField txtPhone;
    @javafx.fxml.FXML
    private TextField txtCustomerID;
    @javafx.fxml.FXML
    private TextField txtUsername;
    @javafx.fxml.FXML
    private TextField txtFullName;
    @javafx.fxml.FXML
    private TextField txtEmail;

    @javafx.fxml.FXML
    public void handleUpdate(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/customerSupportStaff/support_dashboard.fxml", actionEvent);
    }
    //update customer info
}
