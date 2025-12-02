package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.modelClass.SupportReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SupportReportController extends BaseController {
    @javafx.fxml.FXML
    private TableColumn <SupportReport, String> colCustomerName;
    @javafx.fxml.FXML
    private TableColumn <SupportReport, String> colComplaintType;
    @javafx.fxml.FXML
    private TableView <SupportReport> tblReports;
    @javafx.fxml.FXML
    private TableColumn <SupportReport, String> colStatus;

    ArrayList<SupportReport> data = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colComplaintType.setCellValueFactory(new PropertyValueFactory<>("complaintTitle"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void handleRefresh(ActionEvent actionEvent) {
        data.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("complaints.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {

                int startName = line.indexOf("customerName='") + 14;
                int endName = line.indexOf("'", startName);
                String customerName = line.substring(startName, endName);

                int startTitle = line.indexOf("complaintTitle='") + 16;
                int endTitle = line.indexOf("'", startTitle);
                String complaintTitle = line.substring(startTitle, endTitle);
                String status = "Unsolved";

                SupportReport report = new SupportReport(customerName, complaintTitle, status);
                data.add(report);
            }
            //data.clear();
            tblReports.getItems().clear();
            tblReports.getItems().addAll(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


