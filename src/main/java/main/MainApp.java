package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Memuat tampilan dari file FXML
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/form-bmi.fxml"));

        Scene scene = new Scene(loader.load());
        stage.setTitle("Kalkulator BMI");
        stage.setScene(scene);
        stage.setMinWidth(460);
        stage.setMinHeight(540);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
