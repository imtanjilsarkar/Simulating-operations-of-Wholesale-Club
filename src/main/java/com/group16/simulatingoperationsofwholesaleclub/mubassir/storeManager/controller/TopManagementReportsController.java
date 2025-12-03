package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.DatePicker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopManagementReportsController {

    @FXML
    private TextArea reportOutputTA;


    private final String FILE_PATH = "C:\\Users\\MUBASSIR_MOHI\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\daily_operations.txt";


    @FXML
    public void showReportBTN() {
        reportOutputTA.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                reportOutputTA.appendText(line + "\n");
            }
        } catch (IOException e) {
            reportOutputTA.setText("Error loading report!");
            e.printStackTrace();
        }
    }


    @FXML
    public void backBTN(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchTo(
                    "/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/storemanager_dashboard.fxml",
                    actionEvent
            );
        } catch (IOException e) {
            reportOutputTA.setText("Error going back!");
            e.printStackTrace();
        }
    }
}
