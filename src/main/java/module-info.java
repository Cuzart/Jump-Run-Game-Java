module AgChSaJo {                     //package-Name
    requires javafx.controls;
    requires javafx.fxml;
    requires log4j.api;
    opens AgChSaJo to javafx.fxml, log4j.api;
    exports AgChSaJo;
}