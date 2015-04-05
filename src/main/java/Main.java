import org.jsoup.Jsoup;

import java.net.URL;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore", "src/main/resources/stars.jks");

        get("/:code", (request, response) -> {
            String url = "https://stars.bilkent.edu.tr/homepage/ajax/plainOfferings.php?COURSE_CODE=" + request.params("code").toUpperCase() + "&SEMESTER=20142";
            return Jsoup.parse(new URL(url), 10000).html().toString();
        });
    }
}