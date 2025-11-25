package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CustomerComplaintGoalController
{
    @javafx.fxml.FXML
    private TextArea complaintDetailsTF;
    @javafx.fxml.FXML
    private TextField customerIdTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitBTN(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearBTN(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/storemanager_dashboard.fxml",actionEvent);
    }
}