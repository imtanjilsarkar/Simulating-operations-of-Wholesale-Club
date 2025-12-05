package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SalesPerformaneController {

    @FXML
    private TextArea salesOutputTA;

    @FXML
    public void viewReportBTN(ActionEvent actionEvent) {
        try {
            Path filePath = Path.of("purchase_requests.txt");
            String content = Files.readString(filePath);
            salesOutputTA.setText(content);

        } catch (IOException e) {
            salesOutputTA.setText("Error loading report. File not found or unreadable.");
        }
    }

    @FXML
    public void backBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/storemanager_dashboard.fxml", actionEvent);
    }
}
