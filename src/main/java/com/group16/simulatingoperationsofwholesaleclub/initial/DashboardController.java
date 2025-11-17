package com.group16.simulatingoperationsofwholesaleclub.initial;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashboardController {

    @Deprecated
    public void handleEmployee(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleSupport(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleLogout(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleReports(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleDeliveryCoordinator(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleProcurementOfficer(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleCashier(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleCustomerSupport(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/customerSupportStaff/support_dashboard.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleStoreManager(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/storemanager_dashboard.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleInventoryManager(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleHRManager(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/hrManager/hr_manager_dashboard.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleMembershipManager(ActionEvent actionEvent) throws  IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/membership_dashboard.fxml", actionEvent);



    }
    //common dashboard for scene switching
}
