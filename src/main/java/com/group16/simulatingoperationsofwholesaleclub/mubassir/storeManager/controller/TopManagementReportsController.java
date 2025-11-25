package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class TopManagementReportsController {

    @javafx.fxml.FXML
    private TextArea reportOutputTA;
    @javafx.fxml.FXML
    private DatePicker reportDateDP;

    @javafx.fxml.FXML
    public void backBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/storemanager_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void showReportBTN(ActionEvent actionEvent) {
    }
}
