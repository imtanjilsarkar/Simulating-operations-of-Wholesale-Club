package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class HRManagerDashboardController {
    @javafx.fxml.FXML
    public void handlePayroll(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/hrManager/payroll.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleSummaryReport(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/hrManager/hr_summary_report..fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleUpdateEmployee(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/hrManager/update_employee.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleRecruitment(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/hrManager/recruitment.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleAttendance(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/hrManager/attendance.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleLeaveApproval(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/hrManager/leave_approval.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleRemoveEmployee(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/hrManager/remove_employee.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleLogout(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/initial.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleShift(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/hrManager/shift.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/initial/dashboard.fxml", actionEvent);
    }
    //main HR dashboard
}
