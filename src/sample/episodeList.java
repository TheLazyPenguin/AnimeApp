package sample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;



public class episodeList implements Initializable {
    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private Label animeSummary;
    @FXML
    private Label animeTitle;
    @FXML
    private ImageView episodeImage;
    @FXML
    private ListView episodeListView;

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
        objMap.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,true);
        get_Ani anime = objMap.readValue(new URL("https://api.jikan.moe/v3/search/anime?q="+mainController.malurl +"&limit=1"),get_Ani.class);
        animeTitle.setText(mainController.titleS);
        Map<String, Object> map = objMap.readValue(objMap.writeValueAsString(anime.results.get(0)), new TypeReference<Map<String,Object>>(){});
        Anime aniSummary = objMap.readValue(new URL("https://api.jikan.moe/v3/anime/" + String.valueOf(map.get("mal_id"))), Anime.class);
        Anime_Episodes ani_ep = objMap.readValue(new URL("https://api.jikan.moe/v3/anime/" + String.valueOf(map.get("mal_id") + "/episodes/")), Anime_Episodes.class);
        episodeListView.getItems().removeAll();
        list.add("title");
        episodeListView.getItems().add("ytttttttttttttt");
        episodeListView.refresh();

        for (int i =0;ani_ep.episodes.size() > (i);i++) {
            Map<String, Object> eps = objMap.readValue(objMap.writeValueAsString(ani_ep.episodes.get(i)), new TypeReference<Map<String, Object>>() {
            });
            System.out.println(eps.get("title"));
        }
        animeSummary.setText(aniSummary.synopsis);
        setImage();


    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Anime{
        private String synopsis;
        public String getSynopsis(){return this.synopsis;}
        public void setSynopsis(String mal_id) {
            this.synopsis = mal_id;
        }
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Anime_Episodes{
        private List episodes = null;
        public List getEpisodes(){return this.episodes;}
        public void setEpisodes(List episodes){this.episodes = episodes;}


    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class get_Ani{
        private List results = null;
        public List getResults(){return this.results;}
        public void setResults(List results){this.results = results;}


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
