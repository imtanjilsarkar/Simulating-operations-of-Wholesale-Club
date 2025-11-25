package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

public class DailyOperationController {

    @javafx.fxml.FXML
    private TextField lowStockTF;
    @javafx.fxml.FXML
    private TextField staffTF;
    @javafx.fxml.FXML
    private TextArea activityTA;
    @javafx.fxml.FXML
    private TextField salesTF;

    @javafx.fxml.FXML
    public void exportBTN(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addActivityBTN(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/storemanager_dashboard.fxml",actionEvent);
    }
}
