import org.json.JSONArray;

import static spark.Spark.get;

public class Main {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore", "src/main/resources/stars.jks");

        get("/:courseCode", (request, response) -> {
            try {
                JSONArray courses = CourseCode.get(request.params("courseCode"));
                response.status(200);
                return courses.toString(1);
            } catch (Exception e) {
                e.printStackTrace();
                response.status(500);
                return "The server encountered an unexpected condition which prevented it from fulfilling the request.";
            }
        });

        get("/:courseCode/:courseNumber", (request, response) -> {
            try {
                JSONArray courses = CourseNumber.get(request.params("courseCode"), request.params("courseNumber"));
                response.status(200);
                return courses.toString(1);
            } catch (Exception e) {
                e.printStackTrace();
                response.status(500);
                return "The server encountered an unexpected condition which prevented it from fulfilling the request.";
            }
        });

        get("/:courseCode/:courseNumber/:sectionNumber", (request, response) -> {
            try {
                JSONArray courses = SectionNumber.get(request.params("courseCode"), request.params("courseNumber"), request.params("sectionNumber"));
                response.status(200);
                return courses.toString(1);
            } catch (Exception e) {
                e.printStackTrace();
                response.status(500);
                return "The server encountered an unexpected condition which prevented it from fulfilling the request.";
            }
        });
    }
}