package com.group16.simulatingoperationsofwholesaleclub.initial;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ForgotPasswordController {
    @javafx.fxml.FXML
    private PasswordField newPasswordField;
    @javafx.fxml.FXML
    private TextField emailField;
    @javafx.fxml.FXML
    private PasswordField confirmPasswordField;

    @javafx.fxml.FXML
    public void handleResetPassword(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBackToLogin(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/login.fxml", actionEvent);
    }
    //handles password recovery
}
