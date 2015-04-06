import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

public class CourseCode {
    public static JSONArray get(String courseCode) {
        String url = "https://stars.bilkent.edu.tr/homepage/ajax/plainOfferings.php?SEMESTER=20142&COURSE_CODE=" + courseCode.toUpperCase();

        JSONArray courses = new JSONArray();

        try {
            Document doc = Jsoup.parse(new URL(url), 10000);
            Element table = doc.getElementById("poTable");
            Elements rows = table.getElementsByTag("tr");

            for (Element row : rows.subList(2, rows.size())) {
                courses.put(CourseFactory.create(row));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }
}
