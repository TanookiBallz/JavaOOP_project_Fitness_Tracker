module com.example.fitnesstracker {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.fitnesstracker to javafx.fxml;
    exports com.example.fitnesstracker;

    opens com.example.fitnesstracker.Controllers to javafx.fxml;
}