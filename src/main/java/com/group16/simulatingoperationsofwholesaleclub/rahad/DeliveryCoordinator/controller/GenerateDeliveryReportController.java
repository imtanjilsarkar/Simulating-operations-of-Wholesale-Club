package com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass.AssignedDelivery;
import com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.modelClass.ConfirmOrders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import org.openpdf.text.Document;
import org.openpdf.text.DocumentException;
import org.openpdf.text.Paragraph;
import org.openpdf.text.Table;
import org.openpdf.text.pdf.PdfWriter;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GenerateDeliveryReportController {

    private static final String ASSIGNED_FILE = "C:/Users/rubay/IdeaProjects/Simulating-operations-of-Wholesale-Club/assigned_deliveries.dat";
    private static final String CONFIRMED_FILE = "C:/Users/rubay/IdeaProjects/Simulating-operations-of-Wholesale-Club/confirmed_orders.dat";

    @FXML
    private TableView<ReportRow> reportTable;
    @FXML
    private TableColumn<ReportRow, String> colOrderID;
    @FXML
    private TableColumn<ReportRow, String> colStatus;
    @FXML
    private TableColumn<ReportRow, String> colDate;

    @FXML
    private Label statusLabel;

    private ObservableList<ReportRow> reportData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colOrderID.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @FXML
    public void handleGenerateReport(ActionEvent event) {
        reportData.clear();

        List<AssignedDelivery> assignedList = readAssignedDeliveries();
        List<ConfirmOrders> confirmedList = readConfirmedOrders();

        for (AssignedDelivery ad : assignedList) {
            boolean delivered = confirmedList.stream().anyMatch(c -> c.getOrderId().equals(ad.getOrderId()));
            String status = delivered ? "Delivered" : "In Process";

            reportData.add(new ReportRow(ad.getOrderId(), status, ad.getDeliveryDate()));
        }

        reportTable.setItems(reportData);
        statusLabel.setText("Report generated successfully!");
    }

    @FXML
    public void handleDownloadReport(ActionEvent event) {
        if (reportTable.getItems().isEmpty()) {
            statusLabel.setText("⚠ Generate the report first!");
            return;
        }

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save Delivery Report PDF");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Document (.pdf)", "*.pdf"));

        File file = chooser.showSaveDialog(reportTable.getScene().getWindow());
        if (file == null) return;

        try {
            Document pdf = new Document();
            PdfWriter.getInstance(pdf, new FileOutputStream(file));

            pdf.open();
            pdf.add(new Paragraph("Delivery Report"));
            pdf.add(new Paragraph("Generated on: " + LocalDate.now()));
            pdf.add(new Paragraph("Total Orders: " + reportTable.getItems().size()));
            pdf.add(new Paragraph(" "));

            Table pdfTable = new Table(3);
            pdfTable.addCell("Order ID");
            pdfTable.addCell("Status");
            pdfTable.addCell("Delivery Date");

            for (ReportRow row : reportTable.getItems()) {
                pdfTable.addCell(row.getOrderId());
                pdfTable.addCell(row.getStatus());
                pdfTable.addCell(row.getDate());
            }

            pdf.add(pdfTable);
            pdf.close();

            statusLabel.setText("✅ PDF generated successfully!");

        } catch (IOException | DocumentException e) {
            statusLabel.setText("❌ Error generating PDF!");
            e.printStackTrace();
        }
    }

    @FXML
    public void handleBack(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/rahad/DeliveryCoordinator/delivery_Dashboard.fxml",
                event
        );
    }

    // ------------------- FILE READERS -------------------
    private List<AssignedDelivery> readAssignedDeliveries() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ASSIGNED_FILE))) {
            return (List<AssignedDelivery>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private List<ConfirmOrders> readConfirmedOrders() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CONFIRMED_FILE))) {
            return (List<ConfirmOrders>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // ------------------- Report Row -------------------
    public static class ReportRow {
        private final String orderId;
        private final String status;
        private final String date;

        public ReportRow(String orderId, String status, String date) {
            this.orderId = orderId;
            this.status = status;
            this.date = date;
        }

        public String getOrderId() { return orderId; }
        public String getStatus() { return status; }
        public String getDate() { return date; }
    }
}
