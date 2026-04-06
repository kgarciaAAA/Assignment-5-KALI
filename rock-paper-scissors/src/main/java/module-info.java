module rps {
    requires javafx.controls;
    requires javafx.fxml;

    opens rps to javafx.fxml;
    opens rps.controllers to javafx.fxml;
    exports rps;
}