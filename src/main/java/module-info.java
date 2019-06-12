module AgChSaJo {

    requires javafx.controls;
    requires javafx.fxml;
    requires log4j.api;
    requires json.simple;
    requires jackson.annotations;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    opens AgChSaJo to javafx.fxml, log4j.api, jackson.annotations, com.fasterxml.jackson.core, com.fasterxml.jackson.databind;
    opens AgChSaJo.JumpOrDie to com.fasterxml.jackson.databind;
    exports AgChSaJo.GUI;
}

