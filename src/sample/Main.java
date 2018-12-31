package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

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
        Parent root = FXMLLoader.load(getClass().getResource("Load.fxml"));
        Scene main = new Scene(root,1920,1080);
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