package com.group16.simulatingoperationsofwholesaleclub;

import javafx.event.ActionEvent;

import java.io.IOException;

public class BaseController {
    @javafx.fxml.FXML
    public void handleBackCSD(ActionEvent actionEvent) throws IOException {   // back to CustomerSupportDashBoard (Tanjil)
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/customerSupportStaff/support_dashboard.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleBackHRMD(ActionEvent actionEvent) throws IOException {   // back to HRManagerDashboard (Tanjil)
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/hrManager/hr_manager_dashboard.fxml", actionEvent);
    }  //tanjil
}
