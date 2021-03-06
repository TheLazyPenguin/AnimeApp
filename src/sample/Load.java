package sample;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.util.*;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;


public class Load implements Initializable{
    public HashMap<String,Image> foo;
   public HashMap<String,Image> foo2;
   public HashMap<String,Image> foo3;
   public static Thread t4;
   @FXML
   private  StackPane loadStack;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (mainController.fetched == false) {
        scrapeData scrape = new scrapeData();
        mainController controller = new mainController();
        t4 = new Thread(() -> {
            try {
                foo = scrape.fetch_mPop();
                foo2 = scrape.fetch_rec();
                foo3 = scrape.fetch_trend();
                controller.start(foo,foo2,foo3);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t4.start();
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(5000),
                    e -> {
                        Parent root2 = null;
                        try {
                            root2 = FXMLLoader.load(getClass().getResource("Scenes/Main.fxml"));

                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        Main.window.getScene().setRoot(root2);


                    }));
            timeline.play();



    }




    }
}
