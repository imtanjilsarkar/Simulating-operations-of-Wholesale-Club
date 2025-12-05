package com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.modelClass.NewMembership;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.scene.control.Label;


import org.openpdf.text.Document;
import org.openpdf.text.DocumentException;
import org.openpdf.text.Paragraph;
import org.openpdf.text.Table;
import org.openpdf.text.pdf.PdfWriter;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MembershipReportsController {

    @FXML
    private TableView<MembershipRow> reportTable;

    @FXML
    private TableColumn<MembershipRow, Integer> idCol;

    @FXML
    private TableColumn<MembershipRow, String> nameCol;

    @FXML
    private TableColumn<MembershipRow, String> statusCol;

    @FXML
    private TableColumn<MembershipRow, String> validTillCol;

    private static final String FILE_PATH =
            "C:\\Users\\MUBASSIR_MOHI\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\new_memberships.dat";

    private ArrayList<NewMembership> membershipList;
    @FXML
    private Label successLabel;


    @FXML
    public void initialize() {

        idCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("membershipType"));
        validTillCol.setCellValueFactory(new PropertyValueFactory<>("validTill"));

        loadMemberships();
        loadTable();
    }


    private void loadMemberships() {
        membershipList = new ArrayList<>();

        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            while (true) {
                Object obj = ois.readObject();
                if (obj instanceof NewMembership) {
                    membershipList.add((NewMembership) obj);
                }
            }

        } catch (EOFException ignored) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void loadTable() {

        ObservableList<MembershipRow> rows = FXCollections.observableArrayList();

        for (NewMembership m : membershipList) {
            rows.add(new MembershipRow(
                    m.getCustomerId(),
                    m.getCustomerName(),
                    m.getMembershipType(),
                    m.getValidTill()
            ));
        }

        reportTable.setItems(rows);

        if (successLabel != null)
            successLabel.setText("Membership records loaded.");
    }


    @FXML
    public void GeneratePDFBTN(ActionEvent event) {

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save Membership Report PDF");
        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("PDF Document (.pdf)", "*.pdf")
        );

        File file = chooser.showSaveDialog(reportTable.getScene().getWindow());
        if (file == null) return;

        try {

            Document pdf = new Document();
            PdfWriter.getInstance(pdf, new FileOutputStream(file));

            pdf.open();
            pdf.add(new Paragraph("Membership Report"));
            pdf.add(new Paragraph("Generated on: " + LocalDate.now()));
            pdf.add(new Paragraph("Total Members: " + reportTable.getItems().size()));
            pdf.add(new Paragraph(" "));

            Table pdfTable = new Table(4);
            pdfTable.addCell("Customer ID");
            pdfTable.addCell("Name");
            pdfTable.addCell("Status");
            pdfTable.addCell("Valid Till");

            for (MembershipRow row : reportTable.getItems()) {
                pdfTable.addCell(String.valueOf(row.getCustomerId()));
                pdfTable.addCell(row.getCustomerName());
                pdfTable.addCell(row.getMembershipType());
                pdfTable.addCell(row.getValidTill());
            }

            pdf.add(pdfTable);
            pdf.close();

            successLabel.setText("PDF generated successfully!");

        } catch (IOException | DocumentException e) {
            successLabel.setText("Error generating PDF!");
        }
    }


    @FXML
    public void BackBTN(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/mubassir/membershipManager/membership_dashboard.fxml",
                event
        );
    }



    public static class MembershipRow {

        private final int customerId;
        private final String customerName;
        private final String membershipType;
        private final String validTill;

        public MembershipRow(int customerId, String customerName, String membershipType, String validTill) {
            this.customerId = customerId;
            this.customerName = customerName;
            this.membershipType = membershipType;
            this.validTill = validTill;
        }

        public int getCustomerId() { return customerId; }
        public String getCustomerName() { return customerName; }
        public String getMembershipType() { return membershipType; }
        public String getValidTill() { return validTill; }
    }
}
