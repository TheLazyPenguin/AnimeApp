package sample;
import javafx.animation.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.util.*;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;


public class Load implements Initializable{
   public HashMap<String,Image> foo;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scrapeData scrape = new scrapeData();
        mainController controller = new mainController();
        new Thread(() -> {
            try {
                foo = scrape.fetch();
                controller.start(foo);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }).start();
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(2000),
                    e -> {
                        Parent root2 = null;
                        try {
                            root2 = FXMLLoader.load(getClass().getResource("Scenes/Main.fxml"));

                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        Scene main = new Scene(root2, 1920, 1080);

                        Main.changeWindow(main);
                        Main.window.setFullScreen(false);
                        Main.window.setFullScreen(true);

                    }));
            timeline.play();



    }
}
