package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class StaffActivitiesController {

    @javafx.fxml.FXML
    private TextArea activityOutputTA;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private TextField staffIdTF;

    @javafx.fxml.FXML
    public void viewActivitiesBTN(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/storemanager_dashboard.fxml",actionEvent);
    }
}
