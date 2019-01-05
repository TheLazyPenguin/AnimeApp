package sample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;


public class episodeList implements Initializable {
    @FXML
    private Label animeSummary;
    @FXML
    private Label animeTitle;
    @FXML
    private ImageView episodeImage;
    @FXML
    private VBox episodeList;
    @FXML
    private Hyperlink episodetext;
    @FXML
    private AnchorPane episodeTitleAnchor;
    private Image img;
    private BackgroundImage bckgImage;
    private Map<String, Object> eps;
    private boolean got;
    private Stage waitStage = new Stage();
    public static Parent root;

    private void setImage() {
        if (mainController.N <= 13) {
            img = mainController.trendingiv.get(mainController.N).getImage();
            episodeImage.setImage(img);
        } else if (mainController.N >= 14 && mainController.N <= 27) {
            mainController.N -= 14;
            img = mainController.recentiv.get(mainController.N).getImage();
            episodeImage.setImage(img);
        } else if (mainController.N >= 28 && mainController.N <= 41) {
            mainController.N -= 28;
            img = mainController.mPopiv.get(mainController.N).getImage();
            episodeImage.setImage(img);
        }

    }

    @FXML
    private void goBack() {
        waitStage.close();
        Main.window.setFullScreen(true);
    }

    private void getContent() throws IOException {
        ObjectMapper objMap = new ObjectMapper();
        objMap.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        try {
            get_Ani anime = objMap.readValue(new URL("https://api.jikan.moe/v3/search/anime?q=" + mainController.malurl + "&limit=1"), get_Ani.class);
            Map<String, Object> map = objMap.readValue(objMap.writeValueAsString(anime.results.get(0)), new TypeReference<Map<String, Object>>() {
            });
            Anime aniSummary = objMap.readValue(new URL("https://api.jikan.moe/v3/anime/" + String.valueOf(map.get("mal_id"))), Anime.class);
            Anime_Episodes ani_ep = objMap.readValue(new URL("https://api.jikan.moe/v3/anime/" + String.valueOf(map.get("mal_id") + "/episodes/1/")), Anime_Episodes.class);
            episodeList.getChildren().removeAll();
            animeSummary.setText(aniSummary.synopsis);
            for (int i = 0; ani_ep.episodes.size() > (i); i++) {
                if (i <= 24) {
                    eps = objMap.readValue(objMap.writeValueAsString(ani_ep.episodes.get(i)), new TypeReference<Map<String, Object>>() {
                    });

                episodetext = new Hyperlink(String.valueOf(eps.get("title")));
                episodetext.setId("episodeText");
                episodeTitleAnchor.getChildren().add(episodetext);
                episodeTitleAnchor.setLeftAnchor(episodetext, 0.0);
                episodeTitleAnchor.setTopAnchor(episodetext, Double.valueOf(i + 1) * 40.0);}
                else {break;}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        animeTitle.setText(mainController.titleS);
        setImage();


    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Anime {
        private String synopsis;

        public String getSynopsis() {
            return this.synopsis;
        }

        public void setSynopsis(String mal_id) {
            this.synopsis = mal_id;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Anime_Episodes {
        private List episodes = null;

        public List getEpisodes() {
            return this.episodes;
        }

        public void setEpisodes(List episodes) {
            this.episodes = episodes;
        }


    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class get_Ani {
        private List results = null;

        public List getResults() {
            return this.results;
        }

        public void setResults(List results) {
            this.results = results;
        }


    }

    @FXML
    private void escPress(KeyEvent e) {
        if (e.getCode().toString() == "ESCAPE") {
            waitStage.close();
            Main.window.setFullScreen(true);
        }
    }
         

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            root = FXMLLoader.load(getClass().getResource("Scenes/Load.fxml"));
            Scene wait = new Scene(root, 1920, 1080);
            waitStage.setScene(wait);
            waitStage.setFullScreen(true);
            wait.getStylesheets().add("Main.css");
            waitStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Platform.runLater(() -> {
            try {
                getContent();
            } catch (IOException e) {
                e.printStackTrace();
            }
            GaussianBlur blur = new GaussianBlur();
            ColorAdjust bright = new ColorAdjust();
            bright.setInput(blur);
            bright.setBrightness(-0.8);
            episodeList.setEffect(bright);
            waitStage.getScene().setRoot(mainController.root);

        });




    }
}


