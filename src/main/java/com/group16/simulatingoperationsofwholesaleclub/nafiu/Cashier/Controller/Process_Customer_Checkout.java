package com.group16.simulatingoperationsofwholesaleclub.nafiu.Cashier.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Process_Customer_Checkout {
    @javafx.fxml.FXML
    private TextField productIdField;
    @javafx.fxml.FXML
    private Label totalPriceLabel;
    @javafx.fxml.FXML
    private Label finalBillLabel;

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/cashier_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleMembershipCheck(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/apply_membership_discount.fxml",actionEvent);
    }


    @javafx.fxml.FXML
    public void handleAddProduct(ActionEvent actionEvent) {
        String productId = productIdField.getText();
        if (productId.equalsIgnoreCase("fish1")) {
            int price = 100;
            totalPriceLabel.setText("Total Price: " + price + " taka");
        }
        else {
            totalPriceLabel.setText("Product not found!");
        }
    }
    // hhhh
}
