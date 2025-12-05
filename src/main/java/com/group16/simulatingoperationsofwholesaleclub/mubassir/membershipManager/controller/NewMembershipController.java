package com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.modelClass.NewMembership;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class NewMembershipController {

    @FXML
    private ComboBox<String> membershipTypeCB;

    @FXML
    private TextField customerNameTF;

    @FXML
    private DatePicker validTillDP;

    @FXML
    private TextField customerIdTF;

    @FXML
    private Label successLabel;

    private final String FILE_PATH =
            "new_memberships.dat";

    @FXML
    public void initialize() {
        membershipTypeCB.getItems().addAll(
                "Platinum",
                "Diamond",
                "Gold"
        );
    }

    @FXML
    public void BackBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/membership_dashboard.fxml",
                actionEvent
        );
    }

    @FXML
    public void generateIDBTN(ActionEvent actionEvent) {
        Random random = new Random();
        int newId = 10000 + random.nextInt(90000);
        customerIdTF.setText(String.valueOf(newId));
        successLabel.setText("Generated ID: " + newId);
    }

    @FXML
    public void RegisterBTN(ActionEvent actionEvent) {

        if (customerIdTF.getText().isEmpty() || customerNameTF.getText().isEmpty() || membershipTypeCB.getValue() == null || validTillDP.getValue() == null) {
            successLabel.setText(" Please fill all fields!");
            successLabel.setStyle("-fx-text-fill: red;");
            return;
        }
        if (validTillDP.getValue().isBefore(java.time.LocalDate.now())) {
            successLabel.setText(" Date cannot be in the past!");
            successLabel.setStyle("-fx-text-fill: red;");
            return;
        }
        int id = Integer.parseInt(customerIdTF.getText());
        String name = customerNameTF.getText();
        String type = membershipTypeCB.getValue();
        String validTill = validTillDP.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        NewMembership newMem = new NewMembership(id, name, type, validTill);

        try {
            appendMembershipToFile(newMem);
            successLabel.setText(" Membership Registered Successfully!");
        } catch (IOException e) {
            successLabel.setText(" Error saving membership!");
            e.printStackTrace();
        }
    }

    private void appendMembershipToFile(NewMembership membership) throws IOException {
        File file = new File(FILE_PATH);
        boolean append = file.exists();

        FileOutputStream fos = new FileOutputStream(file, true);
        ObjectOutputStream oos;

        if (append) {
            oos = new AppendableObjectOutputStream(fos);
        } else {
            oos = new ObjectOutputStream(fos);
        }

        oos.writeObject(membership);
        oos.close();
    }

    private static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }
        @Override
        protected void writeStreamHeader() {}
    }
}
