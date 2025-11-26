package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class OrderStatusController extends BaseController {
    @javafx.fxml.FXML
    private TableColumn colQuantity;
    @javafx.fxml.FXML
    private TableView orderTable;
    @javafx.fxml.FXML
    private TableColumn colCustomerName;
    @javafx.fxml.FXML
    private TableColumn colProduct;
    @javafx.fxml.FXML
    private TableColumn colOrderId;
    @javafx.fxml.FXML
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void handleRefresh(ActionEvent actionEvent) {
    }
}
