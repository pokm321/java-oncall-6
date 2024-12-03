package oncall.dto;

public record ResultDTO(int month, int date, boolean isHoliday, boolean isWeekend, String dayOfWeek, String worker) {

    public static ResultDTO of(int month, int date, boolean isHoliday,
                               boolean isWeekend, String dayOfWeek, String worker) {
        return new ResultDTO(month, date, isHoliday, isWeekend, dayOfWeek, worker);
    }
}
