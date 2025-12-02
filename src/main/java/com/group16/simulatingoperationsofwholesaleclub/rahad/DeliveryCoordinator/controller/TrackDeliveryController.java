package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class TrackDeliveryController {

    @javafx.fxml.FXML
    private TextField deliveryIdTF;
    @javafx.fxml.FXML
    private TableView deliveryTable;
    @javafx.fxml.FXML
    private TableColumn colLocation;
    @javafx.fxml.FXML
    private TableColumn colDriverName;
    @javafx.fxml.FXML
    private TableColumn colETA;
    @javafx.fxml.FXML
    private TableColumn colOrderID;

    @Deprecated
    public void trackDeliveryBTN(ActionEvent actionEvent) {
    }



    @javafx.fxml.FXML
    public void TrackDeliveryBTN(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/delivery_Dashboard.fxml",actionEvent);
    }
}
