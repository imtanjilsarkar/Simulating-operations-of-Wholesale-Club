package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class FeedbackController {
    @javafx.fxml.FXML
    private TextArea txtFeedback;
    @javafx.fxml.FXML
    private TextArea txtCustomerName;

    @javafx.fxml.FXML
    public void handleSubmit(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/tanjil/customerSupportStaff/support_dashboard.fxml", actionEvent);
    }
    //view customer feedback
}
