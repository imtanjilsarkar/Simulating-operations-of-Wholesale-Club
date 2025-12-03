package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.modelClass.StaffComplaint;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;

public class StaffComplaintGoalController {

    @FXML
    private TextArea complaintDetailsTF;

    @FXML
    private TextField staffIdTF;

    @FXML
    private Label successLabel;

    private final String FILE_PATH =
            "C:\\Users\\MUBASSIR_MOHI\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\staff_complaints.txt";

    @FXML
    public void submitBTN(ActionEvent actionEvent) {
        String staffId = staffIdTF.getText().trim();
        String details = complaintDetailsTF.getText().trim();

        if (staffId.isEmpty() || details.isEmpty()) {
            successLabel.setText("Please fill all fields.");
            successLabel.setStyle("-fx-text-fill: red;");
            return;
        }


        StaffComplaint complaint = new StaffComplaint(staffId, details);


        saveComplaint(complaint);

        successLabel.setStyle("-fx-text-fill: green;");
        successLabel.setText("Complaint submitted successfully.");

        staffIdTF.clear();
        complaintDetailsTF.clear();
    }

    @FXML
    public void backBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/storemanager_dashboard.fxml",
                actionEvent
        );
    }

    private void saveComplaint(StaffComplaint complaint) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(
                    complaint.getStaffId() + "," +
                            complaint.getDetails() + "\n"
            );
        } catch (IOException e) {
            successLabel.setText("Error saving complaint.");
            successLabel.setStyle("-fx-text-fill: red;");
        }
    }
}
