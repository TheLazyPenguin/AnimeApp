package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.beans.property.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
public class Main extends Application {
    Button button;
    Stage window;
    Scene home;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("AniWatch");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene main = new Scene(root,300,275);
        main.getStylesheets().add("viper.css");
        window.setScene(main);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("Exit Request", "Are you sure you want to exit?");
        if (answer) {
            window.close();
        }
    }

}