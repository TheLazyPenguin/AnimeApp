package sample;
import javafx.animation.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.util.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;


public class Load implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(5000),
                e -> {
                    try {
                       Parent root = FXMLLoader.load(getClass().getResource("Scenes/Main.fxml"));
                        Scene main = new Scene(root,1920,1080);
                        Main.changeWindow(main);
                        Main.window.setFullScreen(false);
                        Main.window.setFullScreen(true);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }));
        timeline.play();

    }
}
