package com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.modelClass.SupportReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;

import javafx.stage.FileChooser;
import org.openpdf.text.Document;
import org.openpdf.text.DocumentException;
import org.openpdf.text.Paragraph;
import org.openpdf.text.Table;
import org.openpdf.text.pdf.PdfWriter;

public class SupportReportController extends BaseController {

    @javafx.fxml.FXML
    private TableColumn<SupportReport, String> colCustomerName;
    @javafx.fxml.FXML
    private TableView<SupportReport> tblReports;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableColumn<SupportReport, String> colStatus;

    ObservableList<SupportReport> data = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tblReports.setItems(data);
    }

    @javafx.fxml.FXML
    public void handleLoadComplaints(ActionEvent actionEvent) {
        data.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("complaints.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length < 4) continue; // skip invalid lines

                String customerName = parts[0].trim();
                String status = parts[3].trim();

                data.add(new SupportReport(customerName, "", status));
            }

            if (data.isEmpty()) {
                messageLabel.setText("No complaints found.");
            } else {
                messageLabel.setText("Complaints loaded successfully.");
            }

        } catch (IOException e) {
            messageLabel.setText("Failed to load complaints.");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void exportToPDF(ActionEvent actionEvent) {
        if (data.isEmpty()) {
            messageLabel.setText("No complaint data to export!");
            return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Support Report PDF");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("PDF Document (.pdf)", "*.pdf")
        );
        File file = fileChooser.showSaveDialog(tblReports.getScene().getWindow());
        if (file == null) return;

        try {
            Document pdf = new Document();
            PdfWriter.getInstance(pdf, new FileOutputStream(file));
            pdf.open();

            pdf.add(new Paragraph("Customer Support Report"));
            pdf.add(new Paragraph(" "));
            pdf.add(new Paragraph("Total Complaints: " + data.size()));
            pdf.add(new Paragraph(" "));

            Table pdfTable = new Table(2);
            pdfTable.addCell("Customer Name");
            pdfTable.addCell("Status");

            for (SupportReport s : data) {
                pdfTable.addCell(s.getCustomerName());
                pdfTable.addCell(s.getStatus());
            }

            pdf.add(pdfTable);
            pdf.close();

            messageLabel.setText("PDF generated successfully!");

        } catch (DocumentException | IOException e) {
            messageLabel.setText("Error generating PDF!");
            e.printStackTrace();
        }
    }

}



