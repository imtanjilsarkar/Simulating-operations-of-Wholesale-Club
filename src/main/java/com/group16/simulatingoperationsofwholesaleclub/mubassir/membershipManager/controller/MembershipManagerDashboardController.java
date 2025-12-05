package com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class MembershipManagerDashboardController {

    @javafx.fxml.FXML
    public void MembershipReportsBTN(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/membership_reports.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void BackBTN(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/dashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void RenewMembershipsBTN(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/renew_membership.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void CancelMembershipsBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/cancel_membership.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void LostCardBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/lost_card.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void MembershipIssuesBTN(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/membership_issues.fxml",actionEvent);
    }


    @javafx.fxml.FXML
    public void NewMembershipBTN(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/new_membership.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void BenefitsBTN(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/membership_benefits.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void MembershipInfoBTN(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/membership_info_check.fxml",actionEvent);
    }
}
