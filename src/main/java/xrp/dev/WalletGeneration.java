package xrp.dev;

import io.xpring.xrpl.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class WalletGeneration extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = fxmlLoader.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("MainWindow.fxml"));
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Wallet Generator v1.0");
        primaryStage.show();
    }
}
