package com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.modelClass.NewMembership;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CancelMembershipController {

    private final String FILE_PATH =
            "C:\\Users\\MUBASSIR_MOHI\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\new_memberships.dat";

    private List<NewMembership> membershipList = new ArrayList<>();
    private NewMembership foundMembership = null; // store searched membership
    @FXML
    private TextArea infoTA;
    @FXML
    private Label successLabel;
    @FXML
    private TextField membershipIdTF;

    @FXML
    public void initialize() {
        loadMembershipsFromFile();
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
        } catch (EOFException ignored) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void BackBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/membership_dashboard.fxml",
                actionEvent
        );
    }

    @FXML
    public void searchIDBTN(ActionEvent actionEvent) {
        infoTA.clear();
        successLabel.setText("");

        if (membershipIdTF.getText().isEmpty()) {
            successLabel.setText(" Enter Membership ID");
            return;
        }

        int id = Integer.parseInt(membershipIdTF.getText());
        foundMembership = null;

        for (NewMembership m : membershipList) {
            if (m.getCustomerId() == id) {
                foundMembership = m;
                break;
            }
        }

        if (foundMembership == null) {
            successLabel.setText(" Membership ID Not Found!");
            infoTA.setText("");
            return;
        }


        infoTA.setText(
                "Customer ID: " + foundMembership.getCustomerId() + "\n" +
                        "Name: " + foundMembership.getCustomerName() + "\n" +
                        "Type: " + foundMembership.getMembershipType() + "\n" +
                        "Valid Till: " + foundMembership.getValidTill()
        );

        successLabel.setText(" Membership Found");
    }

    @FXML
    public void CancelMembershipBTN(ActionEvent actionEvent) {

        if (foundMembership == null) {
            successLabel.setText(" Search Membership First!");
            return;
        }

        membershipList.remove(foundMembership);
        foundMembership = null;
        saveMembershipsBackToFile();

        successLabel.setText(" Membership Deleted Successfully!");
        infoTA.clear();
        membershipIdTF.clear();
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

    @Deprecated
    public void handleSearch(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleBack(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleCancel(ActionEvent actionEvent) {
    }
}
