package com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.modelClass.PromotionRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;

public class PromotionController {

    @FXML
    private TextField promoTitleTF;

    @FXML
    private TextArea promoDetailsTF;

    @FXML
    private Label successLabel;

    private final String FILE_PATH =
            "promotions.txt";

    @FXML
    public void approveBTN() {
        String title = promoTitleTF.getText().trim();
        String details = promoDetailsTF.getText().trim();

        if (title.isEmpty() || details.isEmpty()) {
            successLabel.setText("Please fill all fields.");
            successLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        PromotionRequest promotion = new PromotionRequest(title, details, "Approved");

        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(promotion.getTitle() + "," +
                    promotion.getDetails() + "," +
                    promotion.getStatus() + "\n");
            successLabel.setText("Promotion approved and saved.");
            successLabel.setStyle("-fx-text-fill: green;");
        } catch (IOException e) {
            successLabel.setText("Error saving promotion.");
            successLabel.setStyle("-fx-text-fill: red;");
        }

        promoTitleTF.clear();
        promoDetailsTF.clear();
    }

    @FXML
    public void backBTN(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/mubassir/storeManager/storemanager_dashboard.fxml", actionEvent);
    }
}
