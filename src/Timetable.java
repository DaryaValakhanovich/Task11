import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Timetable {
    private ArrayList<Activity> list = new ArrayList();

    public Timetable(String text) {
        ArrayList<Activity> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\d{2}:\\d{2}).(.+)");
        Activity activity = new Activity();
        String time = "";
        Matcher matcher = pattern.matcher(text);
        boolean isItStartOfTheDay = true;
        while (matcher.find()) {
            time = matcher.group(1);
            if (!isItStartOfTheDay){
                activity.setEndTime(time);
                list.add(new Activity(activity.getStartTime(), activity.getEndTime(), activity.getName()));
            }
            if (!Objects.equals(matcher.group(2), "Конец")) {
                activity.setStartTime(time);
                activity.setName(matcher.group(2));
                isItStartOfTheDay = false;
            } else {
                list.add(new Activity());
                isItStartOfTheDay = true;
            }
        }
        this.list = list;
    }

    public ArrayList<Activity> getList() {
        return list;
    }
}
