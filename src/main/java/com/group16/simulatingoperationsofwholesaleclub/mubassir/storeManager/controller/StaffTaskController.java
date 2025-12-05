package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.modelClass.StaffTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StaffTaskController implements Initializable {

    @FXML
    private DatePicker dateDP;
    @FXML
    private TextField staffIdTF;
    @FXML
    private ComboBox<String> taskComboBox;
    @FXML
    private TextArea taskOutputTA;
    @FXML
    private Label successLabel;

    private static final String FILE_PATH =
            "C:\\Users\\MUBASSIR_MOHI\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\staff_tasks.txt";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        taskComboBox.getItems().addAll("Section 1: Inventory Management", "Section 2: Customer Service", "Section 3: Store Cleanup");
        taskComboBox.getSelectionModel().selectFirst();
        successLabel.setText("");
    }


    @FXML
    public void backBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/storemanager_dashboard.fxml", actionEvent);
    }

    @FXML
    public void assignTaskBTN() {
        successLabel.setText("");

        String staffId = staffIdTF.getText().trim();
        LocalDate date = dateDP.getValue();
        String taskSection = taskComboBox.getSelectionModel().getSelectedItem();

        if (staffId.isEmpty() || date == null || taskSection == null) {
            successLabel.setText("ERROR: Please fill all fields.");
            return;
        }

        if (!staffId.matches("\\d+")) {
            successLabel.setText("ERROR: Staff ID must be a number.");
            return;
        }

        StaffTask newTask = new StaffTask(staffId, date, taskSection);

        try {
            saveTaskToFile(newTask);

            taskOutputTA.appendText("Task Assigned Successfully:\n" + newTask.toString() + "\n---\n");

            successLabel.setText("Task assigned successfully.");

            staffIdTF.clear();
            dateDP.setValue(null);
            taskComboBox.getSelectionModel().selectFirst();

        } catch (IOException e) {
            e.printStackTrace();
            successLabel.setText("FATAL ERROR: Failed to save data to file.");
        }
    }

    private void saveTaskToFile(StaffTask task) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            writer.println(task.toString());
        }
    }




}