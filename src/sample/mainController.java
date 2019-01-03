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
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class mainController implements Initializable {
    private static ArrayList<ImageView> trendingiv;
    private static ArrayList<ImageView> recentiv;
    private static ArrayList<ImageView> mPopiv;
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
    @FXML
    private ImageView imageView15;
    @FXML
    private ImageView imageView16;
    @FXML
    private ImageView imageView17;
    @FXML
    private ImageView imageView18;
    @FXML
    private ImageView imageView19;
    @FXML
    private ImageView imageView20;
    @FXML
    private ImageView imageView21;
    @FXML
    private ImageView imageView22;
    @FXML
    private ImageView imageView23;
    @FXML
    private ImageView imageView24;
    @FXML
    private ImageView imageView25;
    @FXML
    private ImageView imageView26;
    @FXML
    private ImageView imageView27;
    @FXML
    private ImageView imageView28;
    @FXML
    private ImageView imageView29;
    @FXML
    private ImageView imageView30;
    @FXML
    private ImageView imageView31;
    @FXML
    private ImageView imageView32;
    @FXML
    private ImageView imageView33;
    @FXML
    private ImageView imageView34;
    @FXML
    private ImageView imageView35;
    @FXML
    private ImageView imageView36;
    @FXML
    private ImageView imageView37;
    @FXML
    private ImageView imageView38;
    @FXML
    private ImageView imageView39;
    @FXML
    private ImageView imageView40;
    @FXML
    private ImageView imageView41;
    @FXML
    private ImageView imageView42;


    public static HashMap<String,Image> trendingHash;
    public static HashMap<String,Image> mPopHash;
    public static HashMap<String,Image> recentHash;
    private int imgN;
    private int imgN2;
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

    public  ArrayList<ImageView> recent(){
        ArrayList<ImageView> recentiv = new ArrayList<>();
        recentiv.add(imageView15);
        recentiv.add(imageView16);
        recentiv.add(imageView17);
        recentiv.add(imageView18);
        recentiv.add(imageView19);
        recentiv.add(imageView20);
        recentiv.add(imageView21);
        recentiv.add(imageView22);
        recentiv.add(imageView23);
        recentiv.add(imageView24);
        recentiv.add(imageView25);
        recentiv.add(imageView26);
        recentiv.add(imageView27);
        recentiv.add(imageView28);

        return recentiv;
    }

    public  ArrayList<ImageView> mPop(){
        ArrayList<ImageView> mPopiv = new ArrayList<>();
        mPopiv.add(imageView29);
        mPopiv.add(imageView30);
        mPopiv.add(imageView31);
        mPopiv.add(imageView32);
        mPopiv.add(imageView33);
        mPopiv.add(imageView34);
        mPopiv.add(imageView35);
        mPopiv.add(imageView36);
        mPopiv.add(imageView37);
        mPopiv.add(imageView38);
        mPopiv.add(imageView39);
        mPopiv.add(imageView40);
        mPopiv.add(imageView41);
        mPopiv.add(imageView42);

        return mPopiv;
    }

    @FXML
    private void imageZoom(Event e){
        String foo = e.getSource().toString();
        foo = foo.substring(foo.indexOf("=")+1);
        foo = foo.substring(0,foo.indexOf(","));
        foo = foo.substring(foo.indexOf("w")+1);
        imgN = Integer.parseInt(foo)-1;
        imgN2 = imgN;
        if (imgN <= 13){
            ScaleTransition zoom = new ScaleTransition(Duration.seconds(0.5),trendingiv.get(imgN));
            zoom.setToX(1.5);
            zoom.setToY(1.5);
            zoom.play();}
        if ( imgN <= 27 && imgN >= 14){
            imgN -= 14;
            ScaleTransition zoom = new ScaleTransition(Duration.seconds(0.5),recentiv.get(imgN));
            zoom.setToX(1.5);
            zoom.setToY(1.5);
            zoom.play();}
        if (imgN <= 41 && imgN >= 28){
            imgN -=28;
            ScaleTransition zoom = new ScaleTransition(Duration.seconds(0.5),mPopiv.get(imgN));
            zoom.setToX(1.5);
            zoom.setToY(1.5);
            zoom.play();}


    }

    @FXML
    private void imageDzoom(Event e){
        if (imgN2 <= 13){
        ScaleTransition zoom = new ScaleTransition(Duration.seconds(0.5),trendingiv.get(imgN2));
        zoom.setToX(1);
        zoom.setToY(1);
        zoom.play();}
        if (imgN2 <= 27 && imgN2 >= 14){
            imgN2 -=14;
            ScaleTransition zoom = new ScaleTransition(Duration.seconds(0.5),recentiv.get(imgN2));
            zoom.setToX(1);
            zoom.setToY(1);
            zoom.play();}
        if (imgN2 <= 41 && imgN2>= 28){
            imgN2 -=28;
            ScaleTransition zoom = new ScaleTransition(Duration.seconds(0.5),mPopiv.get(imgN2));
            zoom.setToX(1);
            zoom.setToY(1);
            zoom.play();}



    }

    public void start(HashMap<String,Image> foo,HashMap<String,Image> foo2,HashMap<String,Image> foo3){
        this.trendingHash = foo3;
        this.mPopHash =  foo;
        this.recentHash = foo2;
        fetched = true;
        init();
    }
    public void init() {
        int a = 0;
        int b = 0;
        int c = 0;
        if (fetched == true) {
            for (Image img : recentHash.values()) {
                if (a <= recentHash.size()-1) {
                    recentiv.get(a).setImage(img);
                }
                a++;
            }
            for (Image img : trendingHash.values()) {
                if (b <= trendingiv.size()-1) {
                    trendingiv.get(b).setImage(img);
                }
                b++;
            }

            for (Image img : mPopHash.values()) {
                if (c <= mPopiv.size()-1) {
                    mPopiv.get(c).setImage(img);
                }
                c++;
            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       trendingiv=trending();
       recentiv = recent();
       mPopiv = mPop();

    }



    }

