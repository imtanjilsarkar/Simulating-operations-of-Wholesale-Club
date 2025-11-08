module project.simulatingoperationsofwholesaleclub {
    requires javafx.controls;
    requires javafx.fxml;


    opens project.simulatingoperationsofwholesaleclub to javafx.fxml;
    exports project.simulatingoperationsofwholesaleclub;
}