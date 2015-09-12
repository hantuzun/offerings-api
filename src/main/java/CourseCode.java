import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CourseCode {
    public static JSONObject get(String courseCode) {
        JSONObject courses = new JSONObject();

        Elements rows = CourseCodeTableCrawler.get(courseCode);

        for (Element row : rows.subList(2, rows.size())) {
            JSONObject course = CourseFactory.create(row);
            try {
                String id = (String) course.keys().next();
                courses.put(id, course.getJSONObject(id));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return courses;
    }
}
