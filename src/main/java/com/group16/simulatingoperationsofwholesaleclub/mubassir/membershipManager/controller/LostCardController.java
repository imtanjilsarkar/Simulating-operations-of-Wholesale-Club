package com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.modelClass.NewMembership;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LostCardController {

    @FXML
    private TextField memberIdTF;

    private final String FILE_PATH =
            "C:\\Users\\MUBASSIR_MOHI\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\new_memberships.dat";

    private List<NewMembership> membershipList = new ArrayList<>();
    private NewMembership selectedMembership = null;
    @FXML
    private TextArea infoTA;
    @FXML
    private TextField newIdTF;
    @FXML
    private Label successLabel;

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
    public void searchIDBTN(ActionEvent actionEvent) {

        if (memberIdTF.getText().isEmpty()) {
            successLabel.setText(" Enter Member ID");
            return;
        }

        int id = Integer.parseInt(memberIdTF.getText());
        selectedMembership = null;

        for (NewMembership m : membershipList) {
            if (m.getCustomerId() == id) {
                selectedMembership = m;
                break;
            }
        }

        if (selectedMembership == null) {
            infoTA.setText("");
            successLabel.setText(" Member ID Not Found");
            return;
        }


        infoTA.setText(
                "Customer Name: " + selectedMembership.getCustomerName() + "\n" +
                        "Membership Type: " + selectedMembership.getMembershipType() + "\n" +
                        "Valid Till: " + selectedMembership.getValidTill()
        );

        successLabel.setText(" Member Found");
    }


    @FXML
    public void generateNewIDBTN(ActionEvent actionEvent) {

        if (selectedMembership == null) {
            successLabel.setText(" Search ID first!");
            return;
        }

        Random random = new Random();
        int newId = 10000 + random.nextInt(90000);
        newIdTF.setText(String.valueOf(newId));

        successLabel.setText(" New ID Generated");
    }


    @FXML
    public void SaveBTN(ActionEvent actionEvent) {

        if (selectedMembership == null) {
            successLabel.setText(" Search a membership first!");
            return;
        }

        if (newIdTF.getText().isEmpty()) {
            successLabel.setText(" Generate a new ID first!");
            return;
        }

        int updatedId = Integer.parseInt(newIdTF.getText());
        selectedMembership.setCustomerId(updatedId);

        saveMembershipsBackToFile();

        successLabel.setText(" New ID Updated Successfully!");
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

}
