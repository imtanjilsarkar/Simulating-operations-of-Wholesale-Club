module project.simulatingoperationsofwholesaleclub {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;



    opens com.group16.simulatingoperationsofwholesaleclub to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub;

    opens com.group16.simulatingoperationsofwholesaleclub.initial to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub.initial;

    opens com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

    opens com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

    opens com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.controller to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.controller;

    opens com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

}