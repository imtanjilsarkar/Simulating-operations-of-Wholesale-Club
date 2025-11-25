package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ApprovePurchaseController {

    @javafx.fxml.FXML
    private TextArea requestDetailsTF;
    @javafx.fxml.FXML
    private TextField requestIdTF;

    @javafx.fxml.FXML
    public void backBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/storemanager_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void approveBTN(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void rejectBTN(ActionEvent actionEvent) {
    }
}
