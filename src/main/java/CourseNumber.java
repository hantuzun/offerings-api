import org.json.JSONArray;
import org.json.JSONObject;

public class CourseNumber {
    public static JSONArray get(String courseCode, String courseNumber) {
        JSONArray courses = CourseCode.get(courseCode);
        JSONArray selectedCourses = new JSONArray();
        for (int i = 0; i < courses.length(); i++) {
            JSONObject course = courses.getJSONObject(i);
            if (course.getJSONObject("course").getString("number").equals(courseNumber)) {
                selectedCourses.put(course);
            }
        }
        return selectedCourses;
    }
}
