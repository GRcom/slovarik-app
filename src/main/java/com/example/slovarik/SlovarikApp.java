package com.example.slovarik;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SlovarikApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        SlovarikStorage.getInstance();

        FXMLLoader fxmlLoader = new FXMLLoader(SlovarikApp.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("SlovarikApp");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
