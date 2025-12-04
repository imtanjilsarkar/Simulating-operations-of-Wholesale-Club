package com.group16.simulatingoperationsofwholesaleclub.nafiu.Inventory.Controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class Inventory_Dashboard {
    @javafx.fxml.FXML
    public void handleReceiveDelivery(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/receive_supplier_delivery.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleSupplierReturns(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleForecastDemand(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/forecast_Demand.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handlePurchaseRequest(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/raise_purchase_request.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleStockReport(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/generate_stock_report.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleUpdateDamaged(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/update_damaged_or_expired goods.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleLogout(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/login.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleOrganizeWarehouse(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleMonitorStock(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Inventory/monitor_stock_level.fxml",actionEvent);
    }
}
