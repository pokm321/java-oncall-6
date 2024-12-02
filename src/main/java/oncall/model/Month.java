package oncall.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.IntStream;
import oncall.dto.MonthInputDTO;

public class Month {

    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final List<String> DAYS_OF_WEEK = List.of("월", "화", "수", "목", "금", "토", "일");
    private static final int NON_LEAP_YEAR = 2001;
    private static final int FIRST_DATE = 1;

    private final List<Day> days;

    private Month(List<Day> days) {
        this.days = days;
    }

    public static Month from(MonthInputDTO monthInputDTO) {
        validateMonthInput(monthInputDTO);

        List<Day> days = new ArrayList<>();

        IntStream.range(FIRST_DATE, getLastDate(monthInputDTO.getMonth()) + 1)
                .forEach(date -> days.add(Day.of(
                        monthInputDTO.getMonth(),
                        date,
                        getDayOfWeek(date, monthInputDTO.getFirstDayOfWeek())
                )));

        return new Month(days);
    }

    private static void validateMonthInput(MonthInputDTO monthInputDTO) {
        if (monthInputDTO.getMonth() < MIN_MONTH || monthInputDTO.getMonth() > MAX_MONTH) {
            throw new IllegalArgumentException();
        }

        if (!DAYS_OF_WEEK.contains(monthInputDTO.getFirstDayOfWeek())) {
            throw new IllegalArgumentException();
        }
    }

    private static int getLastDate(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(NON_LEAP_YEAR, month - 1, FIRST_DATE);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    private static String getDayOfWeek(int date, String firstDayOfWeek) {
        int indexDayOfWeek = (DAYS_OF_WEEK.indexOf(firstDayOfWeek) + date - 1) % DAYS_OF_WEEK.size();
        return DAYS_OF_WEEK.get(indexDayOfWeek);
    }

    public List<Day> getAllDays() {
        return days;
    }
}