package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class videoPlayer implements Initializable {
    @FXML
    private WebView videoView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        WebEngine engine = videoView.getEngine();
        engine.load(episodeList.finEpUrl);
        engine.setCreatePopupHandler(null);
        for (int i =0; i<10;i++){
            System.out.println(engine.getLoadWorker());
        }




    }
}
