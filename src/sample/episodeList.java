package sample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URLEncoder;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;



public class episodeList implements Initializable {

    @FXML
    private Label animeSummary;
    @FXML
    private Label animeTitle;
    @FXML
    private ImageView episodeImage;

    private void setImage() {
        if (mainController.N <= 13) {
            episodeImage.setImage(mainController.trendingiv.get(mainController.N).getImage());
        } else if (mainController.N >= 14 && mainController.N <= 27){
            mainController.N-=14;
            episodeImage.setImage(mainController.recentiv.get(mainController.N).getImage());}
        else if (mainController.N >= 28 && mainController.N <= 41) {
            mainController.N-=28;
            episodeImage.setImage(mainController.mPopiv.get(mainController.N).getImage());}
    }

    @FXML
    private void goBack() {
        mainController.epList.close();
        Main.window.setFullScreen(true);
    }
    private void getContent() throws IOException {

        ObjectMapper objMap = new ObjectMapper();
        Anime anime = objMap.readValue(new URL("https://api.jikan.moe/v3/anime/1/"),Anime.class);
        Anime_Episodes ep = objMap.readValue(new URL("https://api.jikan.moe/v3/anime/1/episodes"), Anime_Episodes.class);
        animeSummary.setText(anime.synopsis);
        animeTitle.setText(mainController.titleS);
        System.out.println(ep.episodes);
        setImage();


    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Anime{
        private String synopsis = null;
        public String getSynopsis(){return this.synopsis;}
        public void setSynopsis(String synopsis){this.synopsis = synopsis;}
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Anime_Episodes{
        private List episodes = null;
        public List getEpisodes(){return this.episodes;}
        public void setEpisodes(List episodes){this.episodes = episodes;}


    }
    @FXML
    private void escPress(KeyEvent e) {
        if (e.getCode().toString() == "ESCAPE") {
        mainController.epList.close();
        Main.window.setFullScreen(true);
        }
        }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getContent();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
