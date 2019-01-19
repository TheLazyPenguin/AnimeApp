package sample;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    private Stage videoStage = new Stage();
    public static Parent root;
    public static String epUrl;
    public static String finEpUrl;
    public static Scene video;
    public static Stage window;

    private HashMap<String,Integer> epList = new HashMap<>();
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
            Anime aniSummary = objMap.readValue(new URL("https://api.jikan.moe/v3/anime/" + (map.get("mal_id"))), Anime.class);
            Anime_Episodes ani_ep = objMap.readValue(new URL("https://api.jikan.moe/v3/anime/" + (map.get("mal_id") + "/episodes/1/")), Anime_Episodes.class);
            episodeList.getChildren().removeAll();
            animeSummary.setText(aniSummary.synopsis);
            for (int i = 0; ani_ep.episodes.size() > (i); i++) {
                if (i <= 24) {
                    eps = objMap.readValue(objMap.writeValueAsString(ani_ep.episodes.get(i)), new TypeReference<Map<String, Object>>() {
                    });

                episodetext = new Hyperlink(String.valueOf(eps.get("title")));
                epList.put((String) eps.get("title"),(Integer) eps.get("episode_id"));
                episodetext.setId("episodeText");
                episodeTitleAnchor.getChildren().add(episodetext);
                episodeTitleAnchor.setLeftAnchor(episodetext, 0.0);
                episodeTitleAnchor.setTopAnchor(episodetext, Double.valueOf(i + 1) * 40.0);
                episodetext.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent e) {
                        try {
                            root = FXMLLoader.load(getClass().getResource("Scenes/Load.fxml"));
                            Scene wait = new Scene(root, 1920, 1080);
                            videoStage.setScene(wait);
                            videoStage.setFullScreen(true);
                            wait.getStylesheets().add("Main.css");
                            videoStage.show();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                    Thread th = new Thread(() -> {
                        try {
                            fetchEpisodeData(e);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    });
                    th.start();
                    }
                });
                }
                else {break;}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        animeTitle.setText(mainController.titleS);
        setImage();


    }
    public void fetchEpisodeData(ActionEvent e) throws IOException {
        String searchUrl = "https://9anime.ru/search?keyword=" + mainController.titleS;
        Document search_doc = Jsoup.connect(searchUrl).get();
        Elements options = search_doc.getElementsByClass("name");
        for (Element title : options) {
            String name = title.text();
            if (mainController.titleS.equals(name)) {
                try {
                mainController.driver.navigate().to(title.attr("href"));}
                catch (TimeoutException er) {
                    WebElement ul = mainController.driver.findElement(By.xpath("//*[@id=\"servers-container\"]/div/div[2]/div[1]/ul[1]"));
                    List<WebElement> a  = ul.findElements(By.tagName("a"));
                    for (WebElement k : a) {
                        if (epList.get(((Hyperlink) e.getSource()).getText()).equals(Integer.parseInt(k.getAttribute("data-base")))){
                            epUrl = k.getAttribute("href");
                            try {mainController.driver.get(epUrl);
                                WebDriverWait webwait = new WebDriverWait(mainController.driver,1);
                                mainController.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                                mainController.driver.findElement(By.xpath("//*[@id=\"player\"]/div[1]")).click();
                                WebElement video  = webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"player\"]/iframe")));
                                finEpUrl = video.getAttribute("src");
                                break;}
                            catch (TimeoutException err){
                                WebDriverWait webwait = new WebDriverWait(mainController.driver,1);
                                mainController.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                                mainController.driver.findElement(By.xpath("//*[@id=\"player\"]/div[1]")).click();
                                WebElement video  = webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"player\"]/iframe")));
                                finEpUrl = video.getAttribute("src");
                                break;}
                        }
                    }
                    break;
                }

            }
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    root = FXMLLoader.load(getClass().getResource("Scenes/videoPlayer.fxml"));
                    video = new Scene(root, 1920, 1080);
                    videoStage.setScene(video);
                    videoStage.setFullScreen(true);
                    video.getStylesheets().add("Main.css");
                    videoStage.show();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        } );



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
        if (e.getCode().toString().equals("ESCAPE")) {
            waitStage.close();
            Main.window.setFullScreen(true);
        }
    }
    private void handle(Event e){


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


