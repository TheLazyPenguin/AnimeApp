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
import java.util.ResourceBundle;

public class mainController implements Initializable {
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String url = "https://static.akacdn.ru/static/images/2018/08/6967cb71e0d219e5b913aed894ba9c16.jpg";
        try {
            URLConnection urlcon = new URL(url).openConnection();
            urlcon.addRequestProperty("User-Agent", "Mozilla/5.0");
            InputStream input = urlcon.getInputStream();
            Image img = new Image(input);

            imageView.setImage(img);
            imageView2.setImage(img);
            imageView3.setImage(img);
            imageView4.setImage(img);
            imageView5.setImage(img);
            imageView6.setImage(img);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
