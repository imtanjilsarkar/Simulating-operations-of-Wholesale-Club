package com.group16.simulatingoperationsofwholesaleclub.initial;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @javafx.fxml.FXML
    private TextField usernameField;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private Label outputLable;

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/initial.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleLogin(ActionEvent actionEvent) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if ((username.equals("tanjil") || username.equals("mohi") || username.equals("nafiu") || username.equals("rahad")) && (password.equals("1234"))){

            SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/dashboard.fxml", actionEvent);
        }
        else {
            outputLable.setText("Username and password do not match");
        }


    }

    @javafx.fxml.FXML
    public void handleForgotPassword(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/forgot_password.fxml", actionEvent);
    }
    //handles login logic
    //yfusdvhsdhbv
}
