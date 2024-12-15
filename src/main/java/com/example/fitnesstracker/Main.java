package com.example.fitnesstracker;

import com.example.fitnesstracker.app.AppController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        
        AppController.getInstance().setStage(stage);
        AppController.getInstance().showLogin();
        
        stage.getScene().getStylesheets().add(getClass().getResource("/com/example/fitnesstracker/style.css").toExternalForm());

        stage.setTitle("Fitness Tracker");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
