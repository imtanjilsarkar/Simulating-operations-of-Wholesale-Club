package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class deliveryCoordinatorDashboardController {

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void returnedOrders(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/verify_returned_orders.fxml",actionEvent);

    }

    @javafx.fxml.FXML
    public void confirmDelivery(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/confirm_delivery.fxml",actionEvent);

    }

    @javafx.fxml.FXML
    public void requestReDelivery(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/re_delivery.fxml",actionEvent);

    }

    @javafx.fxml.FXML
    public void reportProblems(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/return_problems.fxml",actionEvent);
    }



    @javafx.fxml.FXML
    public void trackDelivery(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/track_delivery.fxml",actionEvent);

    }

    @javafx.fxml.FXML
    public void deliveryReport(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/generate_report.fxml",actionEvent);

    }

    @javafx.fxml.FXML
    public void deliverySchedule(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/manage_schedule.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void assignDelivery(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/assigndelivery.fxml",actionEvent);

    }
}
