package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

public class UpdateComplaintController  extends BaseController {
    @javafx.fxml.FXML
    private TextArea descriptionArea;
    @javafx.fxml.FXML
    private TextField customerNameField;
    @javafx.fxml.FXML
    private TextField complaintTitleField;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TextArea complaintTitlesArea;

    @javafx.fxml.FXML
    public void handleUpdateComplaint(ActionEvent actionEvent) {
        try {
            File inputFile = new File("complaints.txt");
            File tempFile = new File("temp_complaints.txt");

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                String line;
                boolean updated = false;

                while ((line = reader.readLine()) != null) {
                    if (line.contains(customerNameField.getText()) &&
                            line.contains(complaintTitleField.getText())) {

                        // build updated line
                        int startDesc = line.indexOf("description='") + 13;
                        int endDesc = line.indexOf("'}", startDesc);
                        String oldDesc = line.substring(startDesc, endDesc);

                        String newLine = line.replace(oldDesc, descriptionArea.getText());
                        writer.write(newLine);
                        writer.newLine();
                        updated = true;
                    } else {
                        writer.write(line);
                        writer.newLine();
                    }
                }

                if (inputFile.delete()) {
                    tempFile.renameTo(inputFile);
                }

                if (updated) {
                    messageLabel.setText("Complaint updated successfully!");
                } else {
                    messageLabel.setText("Complaint not found!");
                }

            }
        } catch (IOException e) {
            messageLabel.setText("Something went wrong!");
        }
    }

    @javafx.fxml.FXML
    public void handleSearchComplaint(ActionEvent actionEvent) {
        try (BufferedReader reader = new BufferedReader(new FileReader("complaints.txt"))) {
            String line;
            String foundTitles = "";
            while ((line = reader.readLine()) != null) {
                if (line.contains(customerNameField.getText())) {
                    int start = line.indexOf("complaintTitle='") + 16;
                    int end = line.indexOf("'", start);
                    String title = line.substring(start, end);
                    foundTitles += title + "\n";
                }
            }
            if (!foundTitles.isEmpty()) {
                complaintTitlesArea.setText(foundTitles); // show all titles
                messageLabel.setText("Complaints found for customer!");
            } else {
                complaintTitlesArea.setText("");
                messageLabel.setText("No complaints found for this customer.");
            }
        } catch (IOException e) {
            messageLabel.setText("Something went wrong!");
        }
    }


    @javafx.fxml.FXML
    public void handleCancel(ActionEvent actionEvent){
        customerNameField.clear();
        complaintTitleField.clear();
        complaintTitlesArea.clear();
        descriptionArea.clear();
        messageLabel.setText("");
}

}


