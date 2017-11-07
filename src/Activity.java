public class Activity {
    private String startTime;
    private String endTime;
    private String name;

    public Activity(String startTime, String endTime, String name) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
    }

    public Activity() {
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", name='" + name + '\'' +
                '}';
    }
}
