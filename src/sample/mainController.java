package sample;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class mainController implements Initializable {
    private static ArrayList<ImageView> trendingiv;
    private static ArrayList<ImageView> recentiv;
    private static ArrayList<ImageView> mPopiv;
    private static ArrayList<AnchorPane> recAnchor;
    private static ArrayList<AnchorPane> trendAnchor;
    private static ArrayList<AnchorPane> mPopAnchor;
    private static ArrayList<Label> recTitle;
    private static ArrayList<Label> trendTitle;
    private static ArrayList<Label> mPopTitle;

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
    //Image Anchors
    @FXML
    private AnchorPane imageAnchor1;
    @FXML
    private AnchorPane imageAnchor2;
    @FXML
    private AnchorPane imageAnchor3;
    @FXML
    private AnchorPane imageAnchor4;
    @FXML
    private AnchorPane imageAnchor5;
    @FXML
    private AnchorPane imageAnchor6;
    @FXML
    private AnchorPane imageAnchor7;
    @FXML
    private AnchorPane imageAnchor8;
    @FXML
    private AnchorPane imageAnchor9;
    @FXML
    private AnchorPane imageAnchor10;
    @FXML
    private AnchorPane imageAnchor11;
    @FXML
    private AnchorPane imageAnchor12;
    @FXML
    private AnchorPane imageAnchor13;
    @FXML
    private AnchorPane imageAnchor14;
    @FXML
    private AnchorPane imageAnchor15;
    @FXML
    private AnchorPane imageAnchor16;
    @FXML
    private AnchorPane imageAnchor17;
    @FXML
    private AnchorPane imageAnchor18;
    @FXML
    private AnchorPane imageAnchor19;
    @FXML
    private AnchorPane imageAnchor20;
    @FXML
    private AnchorPane imageAnchor21;
    @FXML
    private AnchorPane imageAnchor22;
    @FXML
    private AnchorPane imageAnchor23;
    @FXML
    private AnchorPane imageAnchor24;
    @FXML
    private AnchorPane imageAnchor25;
    @FXML
    private AnchorPane imageAnchor26;
    @FXML
    private AnchorPane imageAnchor27;
    @FXML
    private AnchorPane imageAnchor28;
    @FXML
    private AnchorPane imageAnchor29;
    @FXML
    private AnchorPane imageAnchor30;
    @FXML
    private AnchorPane imageAnchor31;
    @FXML
    private AnchorPane imageAnchor32;
    @FXML
    private AnchorPane imageAnchor33;
    @FXML
    private AnchorPane imageAnchor34;
    @FXML
    private AnchorPane imageAnchor35;
    @FXML
    private AnchorPane imageAnchor36;
    @FXML
    private AnchorPane imageAnchor37;
    @FXML
    private AnchorPane imageAnchor38;
    @FXML
    private AnchorPane imageAnchor39;
    @FXML
    private AnchorPane imageAnchor40;
    @FXML
    private AnchorPane imageAnchor41;
    @FXML
    private AnchorPane imageAnchor42;
    //Image Text
    @FXML
    private Label imageTitle1;
    @FXML
    private Label imageTitle2;
    @FXML
    private Label imageTitle3;
    @FXML
    private Label imageTitle4;
    @FXML
    private Label imageTitle5;
    @FXML
    private Label imageTitle6;
    @FXML
    private Label imageTitle7;
    @FXML
    private Label imageTitle8;
    @FXML
    private Label imageTitle9;
    @FXML
    private Label imageTitle10;
    @FXML
    private Label imageTitle11;
    @FXML
    private Label imageTitle12;
    @FXML
    private Label imageTitle13;
    @FXML
    private Label imageTitle14;
    @FXML
    private Label imageTitle15;
    @FXML
    private Label imageTitle16;
    @FXML
    private Label imageTitle17;
    @FXML
    private Label imageTitle18;
    @FXML
    private Label imageTitle19;
    @FXML
    private Label imageTitle20;
    @FXML
    private Label imageTitle21;
    @FXML
    private Label imageTitle22;
    @FXML
    private Label imageTitle23;
    @FXML
    private Label imageTitle24;
    @FXML
    private Label imageTitle25;
    @FXML
    private Label imageTitle26;
    @FXML
    private Label imageTitle27;
    @FXML
    private Label imageTitle28;
    @FXML
    private Label imageTitle29;
    @FXML
    private Label imageTitle30;
    @FXML
    private Label imageTitle31;
    @FXML
    private Label imageTitle32;
    @FXML
    private Label imageTitle33;
    @FXML
    private Label imageTitle34;
    @FXML
    private Label imageTitle35;
    @FXML
    private Label imageTitle36;
    @FXML
    private Label imageTitle37;
    @FXML
    private Label imageTitle38;
    @FXML
    private Label imageTitle39;
    @FXML
    private Label imageTitle40;
    @FXML
    private Label imageTitle41;
    @FXML
    private Label imageTitle42;
    

    public static HashMap<String,Image> trendingHash;
    public static HashMap<String,Image> mPopHash;
    public static
    HashMap<String,Image> recentHash;
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
    private ArrayList<AnchorPane> recAnchor(){
        ArrayList<AnchorPane> recAnchor = new ArrayList<>();
        recAnchor.add(imageAnchor15);
        recAnchor.add(imageAnchor16);
        recAnchor.add(imageAnchor17);
        recAnchor.add(imageAnchor18);
        recAnchor.add(imageAnchor19);
        recAnchor.add(imageAnchor20);
        recAnchor.add(imageAnchor21);
        recAnchor.add(imageAnchor22);
        recAnchor.add(imageAnchor23);
        recAnchor.add(imageAnchor24);
        recAnchor.add(imageAnchor25);
        recAnchor.add(imageAnchor26);
        recAnchor.add(imageAnchor27);
        recAnchor.add(imageAnchor28);



        return recAnchor;
    }

    private ArrayList<AnchorPane> trendAnchor(){
        ArrayList<AnchorPane> trendAnchor = new ArrayList<>();
        trendAnchor.add(imageAnchor1);
        trendAnchor.add(imageAnchor2);
        trendAnchor.add(imageAnchor3);
        trendAnchor.add(imageAnchor4);
        trendAnchor.add(imageAnchor5);
        trendAnchor.add(imageAnchor6);
        trendAnchor.add(imageAnchor7);
        trendAnchor.add(imageAnchor8);
        trendAnchor.add(imageAnchor9);
        trendAnchor.add(imageAnchor10);
        trendAnchor.add(imageAnchor11);
        trendAnchor.add(imageAnchor12);
        trendAnchor.add(imageAnchor13);
        trendAnchor.add(imageAnchor14);

        return trendAnchor;
    }

    private ArrayList<AnchorPane> mPopAnchor() {
        ArrayList<AnchorPane> mPopAnchor = new ArrayList<>();
        mPopAnchor.add(imageAnchor29);
        mPopAnchor.add(imageAnchor30);
        mPopAnchor.add(imageAnchor31);
        mPopAnchor.add(imageAnchor32);
        mPopAnchor.add(imageAnchor33);
        mPopAnchor.add(imageAnchor34);
        mPopAnchor.add(imageAnchor35);
        mPopAnchor.add(imageAnchor36);
        mPopAnchor.add(imageAnchor37);
        mPopAnchor.add(imageAnchor38);
        mPopAnchor.add(imageAnchor39);
        mPopAnchor.add(imageAnchor40);
        mPopAnchor.add(imageAnchor41);
        mPopAnchor.add(imageAnchor42);
        return mPopAnchor;
    }
        private ArrayList<Label> mPopTitle() {
            ArrayList<Label> mPopTitle = new ArrayList<>();
            mPopTitle.add(imageTitle29);
            mPopTitle.add(imageTitle30);
            mPopTitle.add(imageTitle31);
            mPopTitle.add(imageTitle32);
            mPopTitle.add(imageTitle33);
            mPopTitle.add(imageTitle34);
            mPopTitle.add(imageTitle35);
            mPopTitle.add(imageTitle36);
            mPopTitle.add(imageTitle37);
            mPopTitle.add(imageTitle38);
            mPopTitle.add(imageTitle39);
            mPopTitle.add(imageTitle40);
            mPopTitle.add(imageTitle41);
            mPopTitle.add(imageTitle42);
            if (fetched == true) {
            int i = 0;
            for (String title : mPopHash.keySet()) {
                mPopTitle.get(i).setText(title);
                i++;
            }}

            return mPopTitle;

        }
    private ArrayList<Label> trendTitle(){
        ArrayList<Label> trendTitle = new ArrayList<>();
        trendTitle.add(imageTitle1);
        trendTitle.add(imageTitle2);
        trendTitle.add(imageTitle3);
        trendTitle.add(imageTitle4);
        trendTitle.add(imageTitle5);
        trendTitle.add(imageTitle6);
        trendTitle.add(imageTitle7);
        trendTitle.add(imageTitle8);
        trendTitle.add(imageTitle9);
        trendTitle.add(imageTitle10);
        trendTitle.add(imageTitle11);
        trendTitle.add(imageTitle12);
        trendTitle.add(imageTitle13);
        trendTitle.add(imageTitle14);
        if (fetched == true) {
        int i = 0;
        for (String title : trendingHash.keySet()) {
            trendTitle.get(i).setText(title);
            i++;
        }}
        return trendTitle;
    }

    private ArrayList<Label> recTitle() {
        ArrayList<Label> recTitle = new ArrayList<>();
        recTitle.add(imageTitle15);
        recTitle.add(imageTitle16);
        recTitle.add(imageTitle17);
        recTitle.add(imageTitle18);
        recTitle.add(imageTitle19);
        recTitle.add(imageTitle20);
        recTitle.add(imageTitle21);
        recTitle.add(imageTitle22);
        recTitle.add(imageTitle23);
        recTitle.add(imageTitle24);
        recTitle.add(imageTitle25);
        recTitle.add(imageTitle26);
        recTitle.add(imageTitle27);
        recTitle.add(imageTitle28);
        if (fetched == true) {
            int i = 0;
            for (String title : recentHash.keySet()) {
                recTitle.get(i).setText(title);
                i++;
            }

        } return recTitle;
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
            FadeTransition textFadeIn = new FadeTransition(Duration.seconds(0.5), trendTitle.get(imgN));
            textFadeIn.setFromValue(0.0);
            textFadeIn.setToValue(1);
            textFadeIn.setAutoReverse(false);
            ScaleTransition zoom = new ScaleTransition(Duration.seconds(0.5),trendAnchor.get(imgN));
            zoom.setToX(1.5);
            zoom.setToY(1.5);
            zoom.play();
            trendTitle().get(imgN).setVisible(true);
            textFadeIn.play();}
        if ( imgN <= 27 && imgN >= 14){
            imgN -= 14;
            FadeTransition textFadeIn;
            textFadeIn = new FadeTransition(Duration.seconds(0.5), recTitle.get(imgN));
            textFadeIn.setFromValue(0.0);
            textFadeIn.setToValue(1);
            textFadeIn.setAutoReverse(false);
            ScaleTransition zoom = new ScaleTransition(Duration.seconds(0.5),recAnchor().get(imgN));
            zoom.setToX(1.5);
            zoom.setToY(1.5);
            zoom.play();
            recTitle().get(imgN).setVisible(true);
            textFadeIn.play();}
        if (imgN <= 41 && imgN >= 28){
            imgN -=28;
            FadeTransition textFadeIn = new FadeTransition(Duration.seconds(0.5), mPopTitle.get(imgN));
            textFadeIn.setFromValue(0.0);
            textFadeIn.setToValue(1);
            textFadeIn.setAutoReverse(false);
            ScaleTransition zoom = new ScaleTransition(Duration.seconds(0.5),mPopAnchor.get(imgN));
            zoom.setToX(1.5);
            zoom.setToY(1.5);
            zoom.play();
            mPopTitle().get(imgN).setVisible(true);
            textFadeIn.play();
        }


    }

    @FXML
    private void imageDzoom(Event e){
        if (imgN2 <= 13){
            trendTitle = trendTitle();
            FadeTransition textFadeIn = new FadeTransition(Duration.seconds(0.5), trendTitle.get(imgN));
            textFadeIn.setFromValue(1);
            textFadeIn.setToValue(0);
            textFadeIn.setAutoReverse(false);
            ScaleTransition zoom = new ScaleTransition(Duration.seconds(0.5),trendAnchor.get(imgN2));
            zoom.setToX(1);
            zoom.setToY(1);
            zoom.play();
            textFadeIn.play();}
        if (imgN2 <= 27 && imgN2 >= 14){
            imgN2 -=14;
            FadeTransition textFadeIn = new FadeTransition(Duration.seconds(0.5), recTitle.get(imgN2));
            textFadeIn.setFromValue(1.0);
            textFadeIn.setToValue(0.0);
            textFadeIn.setAutoReverse(false);
            ScaleTransition zoom = new ScaleTransition(Duration.seconds(0.5),recAnchor.get(imgN2));
            zoom.setToX(1);
            zoom.setToY(1);
            zoom.play();
            textFadeIn.play();}
        if (imgN2 <= 41 && imgN2>= 28){
            imgN2 -=28;
            FadeTransition textFadeIn = new FadeTransition(Duration.seconds(0.5), mPopTitle.get(imgN2));
            textFadeIn.setFromValue(1);
            textFadeIn.setToValue(0.0);
            textFadeIn.setAutoReverse(false);
            ScaleTransition zoom = new ScaleTransition(Duration.seconds(0.5),mPopAnchor.get(imgN2));
            zoom.setToX(1);
            zoom.setToY(1);
            zoom.play();
            textFadeIn.play();}



    }

    public void start(HashMap<String,Image> foo,HashMap<String,Image> foo2,HashMap<String,Image> foo3) throws InterruptedException {
        this.trendingHash = foo3;
        this.mPopHash =  foo;
        this.recentHash = foo2;
        fetched = true;
        Thread.sleep(500);
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
       trendingiv = trending();
       recentiv = recent();
       mPopiv = mPop();
       trendAnchor = trendAnchor();
       recAnchor = recAnchor();
       mPopAnchor = mPopAnchor();
       trendTitle= trendTitle();
       recTitle = recTitle();
       mPopTitle = mPopTitle();



    }



    }

