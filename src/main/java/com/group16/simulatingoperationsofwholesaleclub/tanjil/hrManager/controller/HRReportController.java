package com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

import com.group16.simulatingoperationsofwholesaleclub.BaseController;
import com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.modelClass.Employee;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.stage.FileChooser;
import org.openpdf.text.Document;
import org.openpdf.text.DocumentException;
import org.openpdf.text.Paragraph;
import org.openpdf.text.Table;
import org.openpdf.text.pdf.PdfWriter;


public class HRReportController extends BaseController {
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colName;
    @javafx.fxml.FXML
    private Label outputMessage;
    @javafx.fxml.FXML
    private TableView <Employee> employeeTable;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colId;
    @javafx.fxml.FXML
    private TableColumn <Employee, Double> colSalary;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colPosition;
    @javafx.fxml.FXML
    private TableColumn <Employee, String> colDepartment;

    List<Employee> employeeList = new ArrayList<>();

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
    }


    @javafx.fxml.FXML
    public void exportToPDF(ActionEvent actionEvent) {
        if (employeeList.isEmpty()) {
            outputMessage.setText("No employee data to export!");
            return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save HR Report PDF");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Document (.pdf)", "*.pdf"));
        File file = fileChooser.showSaveDialog(employeeTable.getScene().getWindow());
        if (file == null) return;

        try {
            Document pdf = new Document();
            PdfWriter.getInstance(pdf, new FileOutputStream(file));
            pdf.open();

            pdf.add(new Paragraph("HR Report"));
            pdf.add(new Paragraph("Generated on: " + LocalDate.now()));
            pdf.add(new Paragraph("Total Employees: " + employeeList.size()));
            pdf.add(new Paragraph(" "));

            Table pdfTable = new Table(5);
            pdfTable.addCell("ID");
            pdfTable.addCell("Name");
            pdfTable.addCell("Department");
            pdfTable.addCell("Position");
            pdfTable.addCell("Salary");

            for (Employee emp : employeeList) {
                pdfTable.addCell(emp.getId());
                pdfTable.addCell(emp.getName());
                pdfTable.addCell(emp.getDepartment());
                pdfTable.addCell(emp.getPosition());
                pdfTable.addCell(String.valueOf(emp.getSalary()));
            }

            pdf.add(pdfTable);
            pdf.close();

            outputMessage.setText("PDF generated successfully!");
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            outputMessage.setText("Error generating PDF!");
        }
    }

    @javafx.fxml.FXML
    public void handleLoadReport(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.bin"))) {
            employeeList = (List<Employee>) in.readObject();
            employeeTable.setItems(FXCollections.observableArrayList(employeeList));
            outputMessage.setText("HR Report loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            outputMessage.setText("Could not load employee data.");
            e.printStackTrace();
        }
    }

}
