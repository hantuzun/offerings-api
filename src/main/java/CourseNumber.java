import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class CourseNumber {
    public static JSONObject get(String courseCode, String courseNumber) {
        JSONObject courses = CourseCode.get(courseCode);
        Iterator<String> keys = courses.keys();
        JSONObject selectedCourses = new JSONObject();
        while(keys.hasNext()) {
            try {
                String key = (String) keys.next();
                JSONObject course = (JSONObject) courses.get(key);

                if (course instanceof JSONObject && course.getJSONObject("details").getString("number").equals(courseNumber)) {
                    selectedCourses.put(key, course);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return selectedCourses;
    }
}
