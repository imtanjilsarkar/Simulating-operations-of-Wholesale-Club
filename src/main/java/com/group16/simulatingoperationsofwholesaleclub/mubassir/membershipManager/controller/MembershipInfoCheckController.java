package com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.modelClass.NewMembership;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MembershipInfoCheckController {

    @FXML
    private TextField memberIdTF;

    @FXML
    private TableView<NewMembership> infoTable;

    @FXML
    private TableColumn<NewMembership, Integer> idCol;

    @FXML
    private TableColumn<NewMembership, String> nameCol;

    @FXML
    private TableColumn<NewMembership, String> statusCol;

    @FXML
    private TableColumn<NewMembership, String> validTillCol;

    @FXML
    private Label successLabel;

    private final String FILE_PATH =
            "C:\\Users\\MUBASSIR_MOHI\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\new_memberships.dat";

    private List<NewMembership> membershipList = new ArrayList<>();


    @FXML
    public void initialize() {

        idCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("membershipType"));
        validTillCol.setCellValueFactory(new PropertyValueFactory<>("validTill"));

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

        } catch (EOFException eof) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void ShowInfoBTN(ActionEvent actionEvent) {

        if (memberIdTF.getText().isEmpty()) {
            successLabel.setText(" Enter a Member ID!");
            infoTable.getItems().clear();
            return;
        }

        int searchId;
        try {
            searchId = Integer.parseInt(memberIdTF.getText());
        } catch (NumberFormatException e) {
            successLabel.setText(" Invalid ID format!");
            return;
        }

        NewMembership found = null;

        for (NewMembership m : membershipList) {
            if (m.getCustomerId() == searchId) {
                found = m;
                break;
            }
        }

        if (found == null) {
            successLabel.setText(" Member Not Found!");
            infoTable.getItems().clear();
            return;
        }

        ObservableList<NewMembership> data = FXCollections.observableArrayList(found);
        infoTable.setItems(data);

        successLabel.setText(" Member Found!");
    }


    @FXML
    public void BackBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/membership_dashboard.fxml",
                actionEvent
        );
    }

}
