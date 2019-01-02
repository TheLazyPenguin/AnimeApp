package sample;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.*;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class mainController implements Initializable {
    private static ArrayList<ImageView> trendingiv;
    @FXML
    private ImageView imageView1;
    @FXML
    private ImageView imageView2;
    @FXML
    private ImageView imageView3;
    @FXML
    private ImageView imageView4;
    @FXML
    private ImageView imageView5;
    @FXML
    private ImageView imageView6;
    @FXML
    private ImageView imageView7;
    @FXML
    private ImageView imageView8;
    @FXML
    private ImageView imageView9;
    @FXML
    private ImageView imageView10;
    @FXML
    private ImageView imageView11;
    @FXML
    private ImageView imageView12;
    @FXML
    private ImageView imageView13;
    @FXML
    private ImageView imageView14;
    public static HashMap<String,Image> trendingHash;
    private int imgN;
    private static boolean fetched = false;

    public  ArrayList<ImageView> trending(){
        ArrayList<ImageView> trendingiv = new ArrayList<>();
        trendingiv.add(imageView1);
        trendingiv.add(imageView2);
        trendingiv.add(imageView3);
        trendingiv.add(imageView4);
        trendingiv.add(imageView5);
        trendingiv.add(imageView6);
        trendingiv.add(imageView7);
        trendingiv.add(imageView8);
        trendingiv.add(imageView9);
        trendingiv.add(imageView10);
        trendingiv.add(imageView11);
        trendingiv.add(imageView12);
        trendingiv.add(imageView13);
        trendingiv.add(imageView14);

        return trendingiv;
    }
    @FXML
    private void imageZoom(Event e){
        String foo = e.getSource().toString();
        foo = foo.substring(foo.indexOf("=")+1);
        foo = foo.substring(0,foo.indexOf(","));
        foo = foo.substring(foo.indexOf("w")+1);
        imgN = Integer.parseInt(foo)-1;
        ScaleTransition zoom = new ScaleTransition(Duration.seconds(0.5),trendingiv.get(imgN));
        zoom.setToX(1.5);
        zoom.setToY(1.5);
        zoom.play();


    }

    @FXML
    private void imageDzoom(Event e){
        ScaleTransition zoom = new ScaleTransition(Duration.seconds(0.5),trendingiv.get(imgN));
        zoom.setToX(1);
        zoom.setToY(1);
        zoom.play();


    }

    public void start(HashMap<String,Image> foo){
        int i = 0;
        this.trendingHash = foo;
        fetched = true;
        init();
    }
    public void init() {
        int i = 0;
        if (fetched == true) {
            System.out.println(trendingHash.keySet());
            System.out.println(trendingiv);
            for (Image img : trendingHash.values()) {
                if (i <= 13) {
                    trendingiv.get(i).setImage(img);
                }
                i++;
            }
        }}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       trendingiv=trending();

    }



    }

