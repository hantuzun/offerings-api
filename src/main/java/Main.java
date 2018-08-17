import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.SparkBase.port;

public class Main {
    public static void main(String[] args) {
        port(Integer.parseInt(System.getenv().getOrDefault("PORT", "3000")));

        System.setProperty("javax.net.ssl.trustStore", Main.class.getClassLoader().getResource("stars.jks").getFile());

        get("/", "application/json", (request, response) -> {
            try {
                JSONObject courses = AllCourses.get();
                response.status(200);
                response.type("application/json");
                return courses;
            } catch (Exception e) {
                e.printStackTrace();
                response.status(500);
                return "The server encountered an unexpected condition which prevented it from fulfilling the request.";
            }
        });

        get("/:courseCode", "application/json", (request, response) -> {
            try {
                JSONObject courses = CourseCode.get(request.params("courseCode"));
                response.status(200);
                response.type("application/json");
                return courses;
            } catch (Exception e) {
                e.printStackTrace();
                response.status(500);
                return "The server encountered an unexpected condition which prevented it from fulfilling the request.";
            }
        });

        get("/:courseCode/:courseNumber", (request, response) -> {
            try {
                JSONObject courses = CourseNumber.get(request.params("courseCode"), request.params("courseNumber"));
                response.status(200);
                response.type("application/json");
                return courses;
            } catch (Exception e) {
                e.printStackTrace();
                response.status(500);
                return "The server encountered an unexpected condition which prevented it from fulfilling the request.";
            }
        });

        get("/:courseCode/:courseNumber/:sectionNumber", (request, response) -> {
            try {
                JSONObject courses = SectionNumber.get(request.params("courseCode"), request.params("courseNumber"), request.params("sectionNumber"));
                response.status(200);
                response.type("application/json");
                return courses;
            } catch (Exception e) {
                e.printStackTrace();
                response.status(500);
                return "The server encountered an unexpected condition which prevented it from fulfilling the request.";
            }
        });
    }
}