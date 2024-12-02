package oncall.model;

public class Day {

    private final int month;
    private final int date;
    private final String dayOfWeek;
    private boolean isHoliday;
    private String worker;

    private Day(int month, int date, String dayOfWeek, boolean isHoliday) {
        this.month = month;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.isHoliday = isHoliday;
    }

    public static Day of(int month, int date, String dayOfWeek, boolean isHoliday) {
        return new Day(month, date, dayOfWeek, isHoliday);
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

    public boolean getHoliday() {
        return isHoliday;
    }
}
