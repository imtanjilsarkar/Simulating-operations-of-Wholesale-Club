package com.group16.simulatingoperationsofwholesaleclub.nafiu.Inventory.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Forecast_Demand {
    @javafx.fxml.FXML
    private TextArea forecastArea;
    @javafx.fxml.FXML
    private TextField pastdata;

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/inventory_dashboard.fxml",actionEvent);
    }
    @javafx.fxml.FXML
    public void handleForecast(ActionEvent actionEvent) {
        String pastData = pastdata.getText();
        String[] numbers = pastData.split(",");
        StringBuilder forecast = new StringBuilder();

        for (String numStr : numbers) {
            try {
                int num = Integer.parseInt(numStr.trim());
                int predicted = num + 40; // simple logic to generate forecast
                forecast.append(predicted).append(",");
            } catch (NumberFormatException e) {
            }
        }
        if (forecast.length() > 0) {
            forecast.deleteCharAt(forecast.length() - 1);
        }
        forecastArea.setText(forecast.toString());
    }
}
