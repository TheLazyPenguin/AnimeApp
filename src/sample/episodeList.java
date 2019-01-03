package sample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URLEncoder;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class episodeList implements Initializable {
    @FXML
    private Label animeSummary;
    @FXML
    private Label animeTitle;





    @FXML
    private void goBack() {
        mainController.epList.close();
        Main.window.setFullScreen(true);
    }
    private void getContent() throws IOException {

        ObjectMapper objMap = new ObjectMapper();
        Anime test = objMap.readValue(new URL("https://api.jikan.moe/v3/anime/1/"),Anime.class);
        animeSummary.setText(test.synopsis);
        animeTitle.setText(mainController.titleS);


    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Anime{
        private String synopsis = null;
        public String getSynopsis(){return this.synopsis;}
        public void setSynopsis(String synopsis){this.synopsis = synopsis;}
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
