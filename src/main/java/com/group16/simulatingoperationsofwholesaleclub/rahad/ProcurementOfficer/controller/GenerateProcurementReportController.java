package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass.SupplierOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import org.openpdf.text.Document;
import org.openpdf.text.DocumentException;
import org.openpdf.text.Paragraph;
import org.openpdf.text.Table;
import org.openpdf.text.pdf.PdfWriter;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class GenerateProcurementReportController {

    @FXML
    private TextArea reportArea;

    @FXML
    private Label successLabel;

    private static final String FILE_PATH =
            "supplier_orders.bin";

    private ArrayList<SupplierOrder> orderList;

    // =============================================================
    // INITIALIZE
    // =============================================================
    @FXML
    public void initialize() {
        loadOrders();
        displayOrders();
    }

    // =============================================================
    // LOAD ORDERS FROM BINARY FILE
    // =============================================================
    private void loadOrders() {
        orderList = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            successLabel.setText("No orders found.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                ArrayList<?> tempList = (ArrayList<?>) obj;
                for (Object o : tempList) {
                    if (o instanceof SupplierOrder) {
                        orderList.add((SupplierOrder) o);
                    }
                }
            }
            successLabel.setText("Orders loaded successfully!");
        } catch (EOFException ignored) {
            successLabel.setText("Orders loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            successLabel.setText("Error loading orders!");
        }
    }

    // =============================================================
    // DISPLAY ORDERS IN TEXTAREA
    // =============================================================
    private void displayOrders() {
        if (orderList.isEmpty()) {
            reportArea.setText("No orders to display.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-12s %-20s %-12s %-12s\n",
                "Supplier ID", "Product", "Quantity", "Due Date"));
        sb.append("--------------------------------------------------------\n");

        for (SupplierOrder o : orderList) {
            sb.append(String.format("%-12s %-20s %-12d %-12s\n",
                    o.getSupplierId(),
                    o.getProductName(),
                    o.getQuantity(),
                    o.getDueDate()));
        }

        reportArea.setText(sb.toString());
    }

    // =============================================================
    // BACK BUTTON
    // =============================================================
    @FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/procurementOff_dashboard.fxml", actionEvent);
    }

    // =============================================================
    // GENERATE PDF
    // =============================================================
    @FXML
    public void downloadReport(ActionEvent actionEvent) {
        if (orderList.isEmpty()) {
            successLabel.setText("⚠ No orders to export!");
            return;
        }

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save Procurement Report PDF");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Document (.pdf)", "*.pdf"));

        File file = chooser.showSaveDialog(reportArea.getScene().getWindow());
        if (file == null) return;

        try {
            Document pdf = new Document();
            PdfWriter.getInstance(pdf, new FileOutputStream(file));
            pdf.open();

            pdf.add(new Paragraph("Procurement Report"));
            pdf.add(new Paragraph("Generated on: " + LocalDate.now()));
            pdf.add(new Paragraph("Total Orders: " + orderList.size()));
            pdf.add(new Paragraph(" "));

            Table pdfTable = new Table(4); // 4 columns: Supplier ID, Product, Quantity, Due Date
            pdfTable.addCell("Supplier ID");
            pdfTable.addCell("Product");
            pdfTable.addCell("Quantity");
            pdfTable.addCell("Due Date");

            for (SupplierOrder order : orderList) {
                pdfTable.addCell(order.getSupplierId());
                pdfTable.addCell(order.getProductName());
                pdfTable.addCell(String.valueOf(order.getQuantity()));
                pdfTable.addCell(order.getDueDate());
            }

            pdf.add(pdfTable);
            pdf.close();

            successLabel.setText("✅ PDF generated successfully!");

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            successLabel.setText("❌ Error generating PDF!");
        }
    }

    @FXML
    public void generateReport(ActionEvent actionEvent) {
    }
}
