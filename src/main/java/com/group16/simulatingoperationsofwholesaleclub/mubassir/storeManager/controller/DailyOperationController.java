package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileWriter;
import java.io.IOException;

public class DailyOperationController {

    @FXML
    private TextField lowStockTF;
    @FXML
    private TextField staffTF;
    @FXML
    private TextField salesTF;
    @FXML
    private Label successLabel;

    private final String FILE_PATH = "C:\\Users\\MUBASSIR_MOHI\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\daily_operations.txt";

    @FXML
    public void addActivityBTN() {
        String sales = salesTF.getText().trim();
        String lowStock = lowStockTF.getText().trim();
        String staff = staffTF.getText().trim();

        if (sales.isEmpty() || lowStock.isEmpty() || staff.isEmpty()) {
            successLabel.setText("Please fill in all fields!");
            successLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        String activityLine = "Sales: " + sales + ", Low Stock: " + lowStock + ", Active Staff: " + staff;

        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(activityLine + "\n");
            successLabel.setText("Activity added successfully!");
            successLabel.setStyle("-fx-text-fill: green;");
            salesTF.clear();
            lowStockTF.clear();
            staffTF.clear();
        } catch (IOException e) {
            successLabel.setText("Error saving activity!");
            successLabel.setStyle("-fx-text-fill: red;");
            e.printStackTrace();
        }
    }

    @FXML
    public void backBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/storemanager_dashboard.fxml",
                actionEvent
        );
    }
}
