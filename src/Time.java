import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time {
    private int hours;
    private int minutes;
    private Pattern pattern = Pattern.compile("(\\d{2}):(\\d{2})");

    public Time(String s) {
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            hours = Integer.parseInt(matcher.group(1));
            minutes = Integer.parseInt(matcher.group(2));
        }
    }

    public int getMinutes() {
        return (hours * 60 + minutes);
    }
}
