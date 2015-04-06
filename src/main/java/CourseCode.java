import org.json.JSONArray;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CourseCode {
    public static JSONArray get(String courseCode) {
        JSONArray courses = new JSONArray();

        Elements rows = CourseCodeTableCrawler.get(courseCode);

        for (Element row : rows.subList(2, rows.size())) {
            courses.put(CourseFactory.create(row));
        }

        return courses;
    }
}
