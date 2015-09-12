import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Iterator;

/**
 * Created by emrehan on 12/09/15.
 */
public class AllCourses {
    public static JSONObject get() {
        JSONObject allCourses = new JSONObject();

        String[] departments = {"ACC", "ADA", "AMER", "ARCH", "BF", "BIM", "BTE", "CAA", "CAD", "CHEM", "CI", "CINT", "CITE", "COMD", "CS", "CTE", "CTIS", "CTP", "DIR", "ECON", "EDEB", "EE", "EEE", "ELIT", "ELS", "EM", "EMBA", "ENG", "ETE", "ETS", "FA", "FRE", "FRL", "FRP", "GE", "GER", "GIA", "GRA", "HART", "HCIV", "HIST", "HISTR", "HUM", "IAED", "IE", "IR", "ITA", "JAP", "LAUD", "LAW", "MAN", "MATH", "MBA", "MBG", "ME", "MIAPP", "MSC", "MSG", "MSN", "MTE", "MUS", "MUSS", "NSC", "PE", "PHIL", "PHYS", "PNT", "POLS", "PREP", "PSYC", "RUS", "SFL", "SOC", "SPA", "TE", "TEFL", "THEA", "THM", "THR", "THS", "TRIN", "TRK", "TTP", "TURK"};
        for (String department : departments) {
            JSONObject departmentCourses = CourseCode.get(department);
            Iterator<String> keys = departmentCourses.keys();
            while (keys.hasNext()) {
                try {
                    String key = (String) keys.next();
                    JSONObject course = (JSONObject) departmentCourses.get(key);
                    allCourses.put(key, course);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return allCourses;
    }
}
