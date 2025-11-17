package com.group16.simulatingoperationsofwholesaleclub.initial;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import java.io.IOException;

public class InitialController {
    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    public void handleLogin(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/login.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleSignup(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/signup.fxml", actionEvent);


    }
    }
    //main entry (login page)

