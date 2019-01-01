package sample;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class scrapeData {
    HashMap<String,String> imgurl;
    String url;
    public HashMap<String,String> fetch(){
    url = "https://9anime.ru/filter?sort=views%3Adesc";
        try {
            Document doc = Jsoup.connect(url).get();
            Element link = doc.select("img").first();
            System.out.println("Link: "+ link.attr("src"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Not Found");
        }

        return imgurl;
    }





}
