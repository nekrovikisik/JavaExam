module com.example.javafx_demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafx_demo to javafx.fxml;
    exports com.example.javafx_demo;
    exports com.example.javafx_demo.controller;
    opens com.example.javafx_demo.controller to javafx.fxml;
}