package net.integriator.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.integriator.controller.MainStage;
import net.integriator.data.SessionManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/mainStage.fxml"));
        Parent root = loader.load();
        MainStage controller = loader.getController();
        controller.setStage(primaryStage);
        primaryStage.setTitle("Integriator");
        root.getStylesheets().add("../styles/main.css");
        primaryStage.setScene(new Scene(root));
        primaryStage.setOnCloseRequest(we -> {
            try {
                SessionManager.tearDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
