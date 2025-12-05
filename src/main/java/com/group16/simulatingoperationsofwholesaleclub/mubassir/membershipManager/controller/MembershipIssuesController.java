package com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MembershipIssuesController {

    @FXML
    private TextArea issueTA;

    @FXML
    public void BackBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/membership_dashboard.fxml", actionEvent);
    }

    @FXML
    public void loadIssueBTN(ActionEvent actionEvent) {
        try {
            Path path = Path.of("membership_requests.txt");

            String content = Files.readString(path);

            issueTA.setText(content);

        } catch (IOException e) {
            issueTA.setText("Could not load issues. File missing or unreadable.");
        }
    }
}
