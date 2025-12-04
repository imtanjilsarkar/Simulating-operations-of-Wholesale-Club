package com.group16.simulatingoperationsofwholesaleclub.nafiu.Inventory.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class Forecast_Demand {
    @javafx.fxml.FXML
    private TextArea pastDataArea;
    @javafx.fxml.FXML
    private TextArea forecastArea;

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/inventory_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleForecast(ActionEvent actionEvent) {
    }
}
