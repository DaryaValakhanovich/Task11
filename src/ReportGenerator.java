import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReportGenerator {
    private ArrayList<Activity> list = new ArrayList<>();

    public ReportGenerator(ArrayList<Activity> list) {
        this.list = list;
    }

    public String timeLineReport(){
        StringBuilder result = new StringBuilder();
        for (Activity activity : list) {
            if (activity.getName() == null) {
                result.append("\n");
            } else {
                result.append(activity.getStartTime() + "-" + activity.getEndTime() + " " + activity.getName() + "\n");
            }
        }
        return result.toString();
    }

    public String summaryTimeReport(){
        StringBuilder result = new StringBuilder();
        int summaryTime = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Перерыв", 0);
        hashMap.put("Решения", 0);
        hashMap.put("Лекции", 0);
        hashMap.put("Упражнения", 0);
        HashMap<String, Integer> lectures = new HashMap<>();
        for (Activity activity : list) {
            if (activity.getName() != null) {
                int time = new Time(activity.getEndTime()).getMinutes() - new Time(activity.getStartTime()).getMinutes();
                summaryTime += time;
                if (hashMap.containsKey(activity.getName())) {
                    hashMap.put(activity.getName(), hashMap.get(activity.getName()) + time);
                } else {
                    hashMap.put("Лекции", time + (hashMap.getOrDefault("Лекции", 0)));
                    lectures.put(activity.getName(), time + (lectures.getOrDefault(activity.getName(), 0)));
                }
            }else {
                for (Map.Entry<String, Integer> entry : hashMap.entrySet()){
                    result.append(entry.getKey() + ": " + entry.getValue() + " минут " + entry.getValue() * 100 / summaryTime + "%\n");
                }
                result.append("Лекции:\n");
                for (Map.Entry<String, Integer> entry : lectures.entrySet()){
                    result.append(entry.getKey() + ": " + entry.getValue() + " минут " + entry.getValue() * 100 / summaryTime + "%\n");
                }
                summaryTime = 0;
                hashMap.put("Перерыв", 0);
                hashMap.put("Решения", 0);
                hashMap.put("Лекции", 0);
                hashMap.put("Упражнения", 0);
                lectures.clear();
                result.append("\n");
            }
        }

        return result.toString();
    }
}
