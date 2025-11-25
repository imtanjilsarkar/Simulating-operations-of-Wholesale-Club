package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StoreManagerDashboardController {
    @javafx.fxml.FXML
    public void ReportsBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/top_management_reports.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void ApprovePurchaseBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/purchase_order.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void SalesPerformanceBTN(ActionEvent actionEvent) throws  IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/sales_performance.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void StaffShiftsBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/staff_shift.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void AuditStaffBTN(ActionEvent actionEvent) throws  IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/staff_activities.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void DailyOperationsBTN(ActionEvent actionEvent) throws  IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/daily_operation.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void CustomerComplaintsBTN(ActionEvent actionEvent)throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/customer_complaints.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void DisC_PromBTN(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/discount_promotions.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void BackBTN(ActionEvent actionEvent) throws  IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/dashboard.fxml",actionEvent);
    }
}
