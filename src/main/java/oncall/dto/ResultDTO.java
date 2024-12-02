package oncall.dto;

public record ResultDTO(int month, int date, boolean isHoliday, boolean isWeekend, String dayOfWeek, String worker) {
}
