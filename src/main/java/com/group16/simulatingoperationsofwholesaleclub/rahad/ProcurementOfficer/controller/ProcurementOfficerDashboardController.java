package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ProcurementOfficerDashboardController {


    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/procurementOff_dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void trackPendingDeliveries(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/track_pen_del.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void generateReport(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/generate_report.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void resolveIssues(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/resolve_issue.fxml",actionEvent);

    }

    @javafx.fxml.FXML
    public void contactSupplier(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/view_supp_info.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void manageRecords(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/manage_records.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void approveQuotation(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/approve_quotation.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void reviewPurchaseRequests(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/purchase_req.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void createSupOrder(ActionEvent actionEvent) throws IOException {

        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/track_pen_del.fxml",actionEvent);
    }
}
