package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class SupportDashboardController {
    @javafx.fxml.FXML
    public void handleUpdateComplaint(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/customerSupportStaff/update_complaint.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleSupportReport(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/customerSupportStaff/support_report.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleNewMembership(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/customerSupportStaff/new_membership.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleUpdateCustomer(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/customerSupportStaff/update_customer.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleOrderStatus(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/customerSupportStaff/order_status.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleCloseComplaint(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/customerSupportStaff/close_complaint.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleAddComplaint(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/customerSupportStaff/add_complaint.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleFeedback(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/customerSupportStaff/feedback.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/dashboard.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleLogout(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/initial.fxml", actionEvent);
    }
    //main support dashboard
}
