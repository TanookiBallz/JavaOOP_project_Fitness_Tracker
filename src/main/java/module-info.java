module org.example.fitness_tracker {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.fitness_tracker to javafx.fxml;
    exports org.example.fitness_tracker;
}