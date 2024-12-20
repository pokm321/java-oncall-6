package oncall.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.IntStream;
import oncall.dto.HolidayDTO;
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

    public static Month from(MonthInputDTO monthInputDTO, List<HolidayDTO> holidayDTOs) {
        validateMonthInput(monthInputDTO);

        List<Day> days = new ArrayList<>();
        IntStream.range(FIRST_DATE, getLastDate(monthInputDTO.month()) + 1)
                .forEach(date -> {
                    int month = monthInputDTO.month();
                    String dayOfWeek = getDayOfWeek(date, monthInputDTO.firstDayOfWeek());
                    boolean isHoliday = isHoliday(month, date, holidayDTOs);
                    days.add(Day.of(month, date, dayOfWeek, isHoliday));
                });

        return new Month(days);
    }

    private static void validateMonthInput(MonthInputDTO monthInputDTO) {
        if (monthInputDTO.month() < MIN_MONTH || monthInputDTO.month() > MAX_MONTH) {
            throw new IllegalArgumentException();
        }

        if (!DAYS_OF_WEEK.contains(monthInputDTO.firstDayOfWeek())) {
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

    private static boolean isHoliday(int month, int date, List<HolidayDTO> holidayDTOs) {
        return holidayDTOs.stream().anyMatch(holiday -> holiday.month() == month && holiday.date() == date);
    }

    public List<Day> getAllDays() {
        return days;
    }
}
