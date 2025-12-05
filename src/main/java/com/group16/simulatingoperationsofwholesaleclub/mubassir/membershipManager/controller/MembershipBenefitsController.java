package com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.modelClass.NewMembership;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MembershipBenefitsController {

    @FXML
    private TextField membershipIdTF;

    @FXML
    private ComboBox<String> statusUpdateCB;

    @FXML
    private TextField currentStatusTF;

    @FXML
    private Label successLabel;

    private final String FILE_PATH =
            "new_memberships.dat";

    private List<NewMembership> membershipList = new ArrayList<>();

    @FXML
    public void initialize() {
        loadMembershipsFromFile();
        statusUpdateCB.getItems().addAll("Platinum", "Diamond", "Gold");
    }

    @FXML
    public void BackBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/membership_dashboard.fxml",
                actionEvent);
    }

    @FXML
    public void searchIDBTN(ActionEvent actionEvent) {
        if (membershipIdTF.getText().isEmpty()) {
            successLabel.setText("⚠ Enter Membership ID");
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
            successLabel.setText(" ID Not Found!");
            currentStatusTF.setText("");
            return;
        }

        currentStatusTF.setText(found.getMembershipType());
        successLabel.setText(" Member Found");
    }

    @FXML
    public void UpdateBenefitsBTN(ActionEvent actionEvent) {

        if (membershipIdTF.getText().isEmpty()
                || statusUpdateCB.getValue() == null) {
            successLabel.setText(" Fill all fields!");
            return;
        }

        int id = Integer.parseInt(membershipIdTF.getText());
        String newStatus = statusUpdateCB.getValue();

        NewMembership found = null;

        for (NewMembership m : membershipList) {
            if (m.getCustomerId() == id) {
                found = m;
                break;
            }
        }

        if (found == null) {
            successLabel.setText(" Member Not Found!");
            return;
        }


        found.setMembershipType(newStatus);


        saveMembershipsBackToFile();

        currentStatusTF.setText(newStatus);
        successLabel.setText(" Membership Status Updated!");
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
            // normal
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveMembershipsBackToFile() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {

            for (NewMembership m : membershipList)
                oos.writeObject(m);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
