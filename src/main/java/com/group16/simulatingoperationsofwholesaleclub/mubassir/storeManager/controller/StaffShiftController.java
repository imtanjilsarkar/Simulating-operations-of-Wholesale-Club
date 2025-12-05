package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class StaffShiftController {

    @FXML
    private TextField shiftTimeTF;
    @FXML
    private DatePicker shiftDateDP;
    @FXML
    private TextField staffIdTF;
    @FXML
    private Label successLabel;


    private final String FILE_PATH = "staff_shifts.txt";


    @FXML
    public void assignShiftBTN() {
        String staffId = staffIdTF.getText().trim();
        String shiftTime = shiftTimeTF.getText().trim();
        String shiftDate = (shiftDateDP.getValue() != null)
                ? shiftDateDP.getValue().format(DateTimeFormatter.ISO_DATE)
                : "";


        if (staffId.isEmpty() || shiftTime.isEmpty() || shiftDate.isEmpty()) {
            successLabel.setText("Please fill in all fields!");
            successLabel.setStyle("-fx-text-fill: red;");
            return;
        }
        if (shiftDateDP.getValue().isBefore(java.time.LocalDate.now())) {
            successLabel.setText(" Date cannot be in the past!");
            successLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(staffId + "," + shiftDate + "," + shiftTime + "\n");
            successLabel.setText("Shift assigned successfully!");
            successLabel.setStyle("-fx-text-fill: green;");


            staffIdTF.clear();
            shiftTimeTF.clear();
            shiftDateDP.setValue(null);

        } catch (IOException e) {
            successLabel.setText("Error saving shift!");
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
