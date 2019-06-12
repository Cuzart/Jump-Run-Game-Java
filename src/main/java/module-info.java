module AgChSaJo {

    requires javafx.controls;
    requires javafx.fxml;
    requires log4j.api;
    requires json.simple;
    requires gson;
    opens AgChSaJo to javafx.fxml, log4j.api;
    exports AgChSaJo.GUI;
}

