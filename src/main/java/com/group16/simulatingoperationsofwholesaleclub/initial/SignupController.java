package com.group16.simulatingoperationsofwholesaleclub.initial;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class SignupController {
    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/initial.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleSignUp(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/login.fxml", actionEvent);
    }
    //handles new user registration
}
