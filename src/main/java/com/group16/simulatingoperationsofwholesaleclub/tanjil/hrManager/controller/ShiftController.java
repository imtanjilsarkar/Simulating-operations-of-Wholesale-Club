package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class ShiftController extends BaseController {
    @javafx.fxml.FXML
    private ComboBox employeeComboBox;
    @javafx.fxml.FXML
    private ComboBox <String> shiftComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        shiftComboBox.getItems().addAll("Morning", "Evening", "Night");

    }

    @javafx.fxml.FXML
    public void handleAssignShift(ActionEvent actionEvent) {
    }

}
