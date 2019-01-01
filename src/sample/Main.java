package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.io.IOException;

public class Main extends Application {
    Button button;
    public static Stage window;
    Scene home;


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("AniWatch");
        window.setOnCloseRequest(e -> {
            e.consume();
            try {
                closeProgram();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        Parent root = FXMLLoader.load(getClass().getResource("Scenes/Load.fxml"));
        Scene load = new Scene(root,1920,1080);
        window.setFullScreen(true);
        load.getStylesheets().add("viper.css");
        window.setScene(load);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void closeProgram() throws IOException {
        boolean answer = confirmBox.display("Confirm Exit");
        if (answer) {
            window.close();
        }
    }
    public static void changeWindow(Scene scene){
        scene.getStylesheets().add("viper.css");
        window.setScene(scene);
    }
}