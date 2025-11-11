module project.simulatingoperationsofwholesaleclub {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.group16.simulatingoperationsofwholesaleclub to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub;
}