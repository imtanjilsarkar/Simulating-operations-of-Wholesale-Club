package com.group16.simulatingoperationsofwholesaleclub.nafiu.Cashier.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Handle_Returns_or_Refunds {
    @javafx.fxml.FXML
    private Label refundAmountLabel;
    @javafx.fxml.FXML
    private TextField productIdField;
    @javafx.fxml.FXML
    private TextField billNoField;
    @javafx.fxml.FXML
    private Label refundConfirmationLabel;
    @javafx.fxml.FXML
    private Label eligibilityLabel;

    @javafx.fxml.FXML
    public void handleVerifyReturnItem(ActionEvent actionEvent) {
        String productId = productIdField.getText();
        String billNo = billNoField.getText();
        if (productId.isEmpty() || billNo.isEmpty()) {
            eligibilityLabel.setText("Please fill all fields!");
            return;
        }
        if (productId.equals("fish1") && billNo.equals("f111")) {
            eligibilityLabel.setText("Positive");
            refundAmountLabel.setText("100 taka");
            refundConfirmationLabel.setText("Confirm Refund");
        }else {
            eligibilityLabel.setText("Not Eligible");
            refundAmountLabel.setText("0");
            refundConfirmationLabel.setText("Refund Denied");
        }
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/cashier_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleSelectReturnItem(ActionEvent actionEvent) {
    }
}
