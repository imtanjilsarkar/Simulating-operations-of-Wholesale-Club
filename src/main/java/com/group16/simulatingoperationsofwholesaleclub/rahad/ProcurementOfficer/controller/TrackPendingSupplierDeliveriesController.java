package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

import com.group16.simulatingoperationsofwholesaleclub.SceneSwitcher;
import com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass.SupplierOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TrackPendingSupplierDeliveriesController {

    @FXML private TableView<SupplierOrderRow> pendingTable;
    @FXML private TableColumn<SupplierOrderRow, String> colDeliveryID;
    @FXML private TableColumn<SupplierOrderRow, String> colSupplierName;
    @FXML private TableColumn<SupplierOrderRow, String> colProduct;
    @FXML private TableColumn<SupplierOrderRow, String> colDueDate;

    private static final String FILE_PATH =
            "C:\\Users\\rubay\\IdeaProjects\\Simulating-operations-of-Wholesale-Club\\supplier_orders.bin";

    @FXML
    public void initialize() {
        colDeliveryID.setCellValueFactory(new PropertyValueFactory<>("deliveryID"));
        colSupplierName.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        colProduct.setCellValueFactory(new PropertyValueFactory<>("productName"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo(
                "/com/group16/simulatingoperationsofwholesaleclub/rahad/ProcurementOfficer/procurementOff_dashboard.fxml",
                actionEvent
        );
    }

    @FXML
    public void loadPendingDeliveries(ActionEvent actionEvent) {

        ArrayList<SupplierOrder> allOrders = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            pendingTable.setItems(FXCollections.observableArrayList());
            return;
        }

        // 1. Read SupplierOrder objects from binary file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                ArrayList<?> tempList = (ArrayList<?>) obj;
                for (Object o : tempList) {
                    if (o instanceof SupplierOrder) {
                        allOrders.add((SupplierOrder) o);
                    }
                }
            }
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // 2. Convert to TableView rows
        ObservableList<SupplierOrderRow> tableRows = FXCollections.observableArrayList();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();

        for (SupplierOrder o : allOrders) {
            boolean delayed = LocalDate.parse(o.getDueDate(), formatter).isBefore(today);
            // All orders are pending, highlight delayed orders if needed in UI
            tableRows.add(new SupplierOrderRow(
                    o.getSupplierId(), // DeliveryID
                    o.getSupplierId(), // SupplierName (replace if you have real name)
                    o.getProductName(),
                    o.getDueDate()
            ));
        }

        pendingTable.setItems(tableRows);
    }

    // ===================== INNER CLASS FOR TABLE ROW =====================
    public static class SupplierOrderRow {
        private final String deliveryID;
        private final String supplierName;
        private final String productName;
        private final String dueDate;

        public SupplierOrderRow(String deliveryID, String supplierName, String productName, String dueDate) {
            this.deliveryID = deliveryID;
            this.supplierName = supplierName;
            this.productName = productName;
            this.dueDate = dueDate;
        }

        public String getDeliveryID() { return deliveryID; }
        public String getSupplierName() { return supplierName; }
        public String getProductName() { return productName; }
        public String getDueDate() { return dueDate; }
    }
}
