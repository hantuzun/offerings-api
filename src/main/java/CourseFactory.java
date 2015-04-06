import org.json.JSONObject;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CourseFactory {
    public static JSONObject create(Element element) {
        JSONObject course = new JSONObject();
        Elements elements = element.getElementsByTag("td");

        String id = elements.get(0).text().trim();
        course.put("id", id);

        JSONObject courseDetails = new JSONObject();
        String department = id.split("-")[0].replaceAll("[0-9]", "").trim();
        courseDetails.put("department", department);
        String number = id.split("-")[0].replaceAll("[A-Z]", "").trim();
        courseDetails.put("number", number);
        String section = id.split("-")[1].trim();
        courseDetails.put("section", section);
        courseDetails.put("name", elements.get(1).text().trim());
        course.put("course", courseDetails);


        course.put("instructor", elements.get(2).text().trim());

        JSONObject hours = new JSONObject();
        hours.put("lecture", elements.get(3).text().trim());
        hours.put("lab", elements.get(4).text().trim());
        course.put("hours", hours);

        JSONObject credits = new JSONObject();
        credits.put("bilkent", elements.get(5).text().trim());
        credits.put("ects", elements.get(6).text().trim());
        course.put("credits", credits);

        JSONObject quotas = new JSONObject();
        quotas.put("total", elements.get(7).text().split(" ")[0].trim());
        quotas.put("available", elements.get(12).text().split(" ")[0].trim());
        course.put("quotas", quotas);

        course.put("schedule", elements.get(14).text().trim());

        return course;
    }
}
