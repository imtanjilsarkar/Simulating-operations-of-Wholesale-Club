package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

import java.io.IOException;

public class StaffShiftController {

    @javafx.fxml.FXML
    private TextField shiftTimeTF;
    @javafx.fxml.FXML
    private DatePicker shiftDateDP;
    @javafx.fxml.FXML
    private TextField staffIdTF;

    @javafx.fxml.FXML
    public void assignShiftBTN(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/storemanager_dashboard.fxml",actionEvent);
    }
}
