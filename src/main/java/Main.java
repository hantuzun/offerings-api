import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

import static spark.Spark.get;

public class Main {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore", "src/main/resources/stars.jks");

        get("/:code", (request, response) -> {
            String url = "https://stars.bilkent.edu.tr/homepage/ajax/plainOfferings.php?SEMESTER=20142&COURSE_CODE=" + request.params("code").toUpperCase();

            try {
                JSONArray courses = new JSONArray();
                Document doc = Jsoup.parse(new URL(url), 10000);
                Element table = doc.getElementById("poTable");

                try {
                    Elements rows = table.getElementsByTag("tr");

                    for (Element row : rows.subList(2, rows.size())) {
                        JSONObject course = new JSONObject();
                        Elements elements = row.getElementsByTag("td");

                        course.put("course", elements.get(0).text());
                        course.put("courseName", elements.get(1).text());
                        course.put("instructor", elements.get(2).text());

                        JSONObject hours = new JSONObject();
                        hours.put("lecture", elements.get(3).text());
                        hours.put("lab", elements.get(4).text());
                        course.put("hours", hours);

                        JSONObject credits = new JSONObject();
                        credits.put("bilkent", elements.get(5).text());
                        credits.put("ects", elements.get(6).text());
                        course.put("credits", credits);

                        JSONObject quotas = new JSONObject();
                        quotas.put("total", elements.get(7).text().split(" ")[0]);
                        quotas.put("available", elements.get(12).text().split(" ")[0]);
                        course.put("quotas", quotas);

                        course.put("schedule", elements.get(14).text());
                        courses.put(course);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                response.status(200);
                return courses.toString(1);
            } catch (HttpStatusException e) {
                e.printStackTrace();
                response.status(e.getStatusCode());
                return e.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
                response.status(500);
                return "The server encountered an unexpected condition which prevented it from fulfilling the request.";
            }
        });
    }
}