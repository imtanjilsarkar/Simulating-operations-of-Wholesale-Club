package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ShiftController {
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
    //assign work shifts
}
