import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

public class CourseCodeTableCrawler {
    public static Elements get(String courseCode) {
        String url = "https://stars.bilkent.edu.tr/homepage/ajax/plainOfferings.php?SEMESTER=20171&COURSE_CODE=" + courseCode.toUpperCase();

        try {
            Document doc = Jsoup.parse(new URL(url), 10000);

            if (doc.getElementById("poDiv").ownText().equals("no course")) {
                return null;
            } else {
                Element table = doc.getElementById("poTable");
                Elements rows = table.getElementsByTag("tr");
                return rows;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Elements();
        }
    }
}
