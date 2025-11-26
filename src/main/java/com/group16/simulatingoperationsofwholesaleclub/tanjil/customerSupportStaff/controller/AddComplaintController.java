package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddComplaintController extends BaseController {
    @javafx.fxml.FXML
    private TextArea descriptionArea;
    @javafx.fxml.FXML
    private TextField customerNameField;
    @javafx.fxml.FXML
    private TextField complaintTitleField;

    @javafx.fxml.FXML
    public void handleCancel(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSubmitComplaint(ActionEvent actionEvent) {
    }
    //add new complaint
}
