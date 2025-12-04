package com.group16.simulatingoperationsofwholesaleclub.nafiu.Inventory.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Update_Damaged_or_Expired_Goods {
    @javafx.fxml.FXML
    private TextArea statusArea;
    @javafx.fxml.FXML
    private TextField productIdField;
    @javafx.fxml.FXML
    private TextField quantityField;

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/inventory_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void deductStock(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void verifyStock(ActionEvent actionEvent) {
    }
}
