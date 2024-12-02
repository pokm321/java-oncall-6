package oncall.model;

import java.util.List;

public class Day {

    private static final List<String> DAYS_OF_WEEK = List.of("월", "화", "수", "목", "금", "토", "일");

    private final int month;
    private final int date;
    private final String dayOfWeek;
    private boolean isHoliday;
    private String worker;

    private Day(int month, int date, String dayOfWeek) {
        this.month = month;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
    }

    public static Day of(int month, int date, String dayOfWeek) {
        validate(month, date, dayOfWeek);
        return new Day(month, date, dayOfWeek);
    }

    private static void validate(int month, int date, String dayOfWeek) {
        validateDayOfWeek(dayOfWeek);
    }

    private static void validateDayOfWeek(String dayOfWeek) {
        if (!DAYS_OF_WEEK.contains(dayOfWeek)) {
            throw new IllegalArgumentException();
        }
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
}
