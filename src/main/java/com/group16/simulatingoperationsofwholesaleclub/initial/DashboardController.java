package com.group16.simulatingoperationsofwholesaleclub.initial;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class DashboardController {

    @Deprecated
    public void handleEmployee(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleSupport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleLogout(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/login.fxml", actionEvent);
    }

    @Deprecated
    public void handleReports(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleDeliveryCoordinator(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/delivery_Dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void handleProcurementOfficer(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleCashier(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/nafiu/Cashier/cashier_dashboard.fxml", actionEvent);
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

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) throws  IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/login.fxml",actionEvent);
    }
    //common dashboard for scene switching
}
