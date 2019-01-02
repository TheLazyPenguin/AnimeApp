package sample;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import javafx.scene.image.Image;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class scrapeData {
    HashMap<String, Image> trendingurl;
    String url;

    private Image img;
    public HashMap<String, Image> fetch() throws IOException {
        url = "https://9anime.ru/filter?sort=views%3Adesc";
        Document doc = Jsoup.connect(url).get();
        Elements link = doc.select("img");
        int i = 0;
        trendingurl = new HashMap<String, Image>();
        for (Element src : link) {

            if (i < 10) {
                URLConnection urlcon = new URL(src.attr("abs:src")).openConnection();
                urlcon.addRequestProperty("User-Agent", "Mozilla/5.0");
                InputStream input = urlcon.getInputStream();
                img = new Image(input);
                trendingurl.put(src.attr("alt"), img);

            } else {
                break;
            }
            i++;
        }
        return trendingurl;
    }
}








