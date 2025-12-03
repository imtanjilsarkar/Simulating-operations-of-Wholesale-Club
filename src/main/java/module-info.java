module project.simulatingoperationsofwholesaleclub {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;
    // requires project.simulatingoperationsofwholesaleclub;
    //requires project.simulatingoperationsofwholesaleclub;
    //requires project.simulatingoperationsofwholesaleclub;


    opens com.group16.simulatingoperationsofwholesaleclub to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub;

    opens com.group16.simulatingoperationsofwholesaleclub.initial to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub.initial;

    opens com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.controller;

    opens com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.modelClass to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub.tanjil.customerSupportStaff.modelClass;

    opens com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.modelClass to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.modelClass;



    opens com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub.tanjil.hrManager.controller;

    opens com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.controller to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub.mubassir.membershipManager.controller;

    opens com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub.mubassir.storeManager.controller;

    opens com.group16.simulatingoperationsofwholesaleclub.nafiu.Cashier.Controller to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub.nafiu.Cashier.Controller;

    opens com.group16.simulatingoperationsofwholesaleclub.nafiu.Inventory to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub.nafiu.Inventory.Controller;

    opens com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;

    opens com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass to javafx.base;

    opens com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller to javafx.fxml;
    exports com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;
//    opens com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller to javafx.fxml;
//    exports com.group16.simulatingoperationsofwholesaleclub.rahad.DeliveryCoordinator.controller;

//    opens com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller to javafx.fxml;
//    exports com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.controller;



}