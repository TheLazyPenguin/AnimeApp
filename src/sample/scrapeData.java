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
    HashMap<String, Image> trendingurl = new HashMap<String, Image>();
    HashMap<String, Image> mPopurl = new HashMap<String, Image>();
    HashMap<String, Image> recurl = new HashMap<String, Image>();
    String mPop_url;
    String trending_url;
    String recent_url;
    private Image img;
    public HashMap<String, Image> fetch_trend() throws IOException {
        trending_url= "https://9anime.ru/filter?genre%5B%5D=1&genre%5B%5D=2&genre%5B%5D=3&genre%5B%5D=4&genre%5B%5D=5&genre%5B%5D=6&genre%5B%5D=7&genre%5B%5D=9&genre%5B%5D=10&genre%5B%5D=11&genre%5B%5D=13&genre%5B%5D=14&genre%5B%5D=16&genre%5B%5D=17&genre%5B%5D=18&genre%5B%5D=19&genre%5B%5D=20&genre%5B%5D=21&genre%5B%5D=22&genre%5B%5D=23&genre%5B%5D=25&genre%5B%5D=26&genre%5B%5D=27&genre%5B%5D=28&genre%5B%5D=29&genre%5B%5D=30&genre%5B%5D=31&genre%5B%5D=32&genre%5B%5D=33&genre%5B%5D=34&genre%5B%5D=35&genre%5B%5D=36&genre%5B%5D=37&genre%5B%5D=38&genre%5B%5D=39&genre%5B%5D=40&genre%5B%5D=41&release%5B%5D=2019&release%5B%5D=2018&status%5B%5D=airing&sort=views%3Adesc";
        Document trend_doc = Jsoup.connect(trending_url).get();
        Elements trend_link = trend_doc.select("img");
        int i = 0;
        for (Element src : trend_link) {
            if (i < 14) {
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
    public HashMap<String,Image> fetch_mPop() throws IOException{
        mPop_url = "https://9anime.ru/filter?sort=views%3Adesc";
        Document mPop_doc = Jsoup.connect(mPop_url).get();
        Elements mPop_link = mPop_doc.select("img");
        int i = 0;
        for (Element src : mPop_link) {
            if (i < 14) {
                URLConnection urlcon = new URL(src.attr("abs:src")).openConnection();
                urlcon.addRequestProperty("User-Agent", "Mozilla/5.0");
                InputStream input = urlcon.getInputStream();
                img = new Image(input);
                mPopurl.put(src.attr("alt"), img);

            } else {
                break;
            }
            i++;
        }
        return mPopurl;

    }

    public HashMap<String,Image> fetch_rec() throws IOException{
        recent_url = "https://9anime.ru/filter?status%5B%5D=airing&sort=episode_last_added_at%3Adesc";
        Document rec_doc = Jsoup.connect(recent_url).get();
        Elements rec_link = rec_doc.select("img");
        int i = 0;
        for (Element src : rec_link) {
            if (i < 14) {
                URLConnection urlcon = new URL(src.attr("abs:src")).openConnection();
                urlcon.addRequestProperty("User-Agent", "Mozilla/5.0");
                InputStream input = urlcon.getInputStream();
                img = new Image(input);
                recurl.put(src.attr("alt"), img);

            } else {
                break;
            }
            i++;
        }
    return recurl;
    }
}








