package com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.modelClass.NewMembership;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RenewMembershipController {

    @FXML
    private DatePicker expiryDP;

    @FXML
    private TextField membershipIdTF;

    @FXML
    private TextField previousdateTF;

    @FXML
    private Label successLabels;

    private final String FILE_PATH =
            "C:\\Users\\MUBASSIR_MOHI\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\new_memberships.dat";

    private List<NewMembership> membershipList = new ArrayList<>();

    @FXML
    public void initialize() {
        loadMembershipsFromFile();
    }

    @FXML
    public void BackBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/membership_dashboard.fxml",
                actionEvent
        );
    }

    @FXML
    public void RenewBTN(ActionEvent actionEvent) {

        if (membershipIdTF.getText().isEmpty() || expiryDP.getValue() == null) {
            successLabels.setText(" Fill ID and New Expiry Date");
            return;
        }

        int id = Integer.parseInt(membershipIdTF.getText());
        NewMembership found = null;

        for (NewMembership m : membershipList) {
            if (m.getCustomerId() == id) {
                found = m;
                break;
            }
        }

        if (found == null) {
            successLabels.setText(" Membership ID Not Found!");
            return;
        }

        String newExpiry = expiryDP.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        found.setValidTill(newExpiry);

        saveMembershipsBackToFile();

        successLabels.setText(" Membership Renewed Successfully!");
        previousdateTF.setText(found.getValidTill());
    }

    private void loadMembershipsFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            while (true) {
                Object obj = ois.readObject();
                if (obj instanceof NewMembership) {
                    membershipList.add((NewMembership) obj);
                }
            }

        } catch (EOFException eof) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveMembershipsBackToFile() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {

            for (NewMembership m : membershipList) {
                oos.writeObject(m);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void searchIDBTN(ActionEvent actionEvent) {
        if (membershipIdTF.getText().isEmpty()) {
            successLabels.setText("⚠ Enter Membership ID");
            return;
        }

        int id = Integer.parseInt(membershipIdTF.getText());
        NewMembership found = null;

        for (NewMembership m : membershipList) {
            if (m.getCustomerId() == id) {
                found = m;
                break;
            }
        }

        if (found == null) {
            successLabels.setText(" ID Not Found");
            previousdateTF.setText("");
            return;
        }

        previousdateTF.setText(found.getValidTill());
        successLabels.setText(" Membership Found");
    }
}
