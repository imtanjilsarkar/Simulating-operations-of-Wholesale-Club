package com.group16.simulatingoperationsofwholesaleclub.nafiu.Cashier.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Balance_Cash_Drawer {
    @javafx.fxml.FXML
    private Label balanceStatusLabel;
    @javafx.fxml.FXML
    private Label comparisonLabel;
    @javafx.fxml.FXML
    private TextField actualCashField;
    @javafx.fxml.FXML
    private Label differenceLabel;

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/Nafiu/Cashier/cashier_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleEndShift(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSubmitCash(ActionEvent actionEvent) {
    }
}
