package sample;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class mainController implements Initializable {
    private ArrayList<ImageView> imagevw;
    @FXML
    private ImageView imageView;
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


    public ArrayList<ImageView> trending(){
        ArrayList<ImageView> imagevw = new ArrayList<ImageView>();
        imagevw.add(imageView);
        imagevw.add(imageView2);
        imagevw.add(imageView3);
        imagevw.add(imageView4);
        imagevw.add(imageView5);
        imagevw.add(imageView6);
        imagevw.add(imageView7);
        imagevw.add(imageView8);
        imagevw.add(imageView9);
        imagevw.add(imageView10);
        return imagevw;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        scrapeData scrape = new scrapeData();
        int i = 0;
        imagevw = trending();
        try {
           HashMap<String,Image> trendingimg = scrape.fetch();
           for (Image img : trendingimg.values()) {
               if (i <= 10) {
                   imagevw.get(i).setImage(img);
               }
               i++;
           }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
