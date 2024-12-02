package oncall.model;

import java.util.List;

public class Day {

    private static final List<String> WEEKENDS = List.of("토", "일");

    private final int month;
    private final int date;
    private final boolean isHoliday;
    private final boolean isWeekend;
    private final String dayOfWeek;
    private String worker;

    private Day(int month, int date, String dayOfWeek, boolean isHoliday, boolean isWeekend) {
        this.month = month;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.isHoliday = isHoliday;
        this.isWeekend = isWeekend;
    }

    public static Day of(int month, int date, String dayOfWeek, boolean isHoliday) {
        return new Day(month, date, dayOfWeek, isHoliday, WEEKENDS.contains(dayOfWeek));
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

}
