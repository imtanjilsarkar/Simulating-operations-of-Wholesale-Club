package com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.io.IOException;


public class MembershipIssuesController {
    @javafx.fxml.FXML
    private TextArea issueTA;

    @javafx.fxml.FXML
    public void BackBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/membership_dashboard.fxml",actionEvent);
    }


    @javafx.fxml.FXML
    public void loadIssueBTN(ActionEvent actionEvent) {
    }
}
