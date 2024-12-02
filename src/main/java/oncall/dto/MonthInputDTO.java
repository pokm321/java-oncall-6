package oncall.dto;

public class MonthInputDTO {
    private final int month;
    private final String firstDayOfWeek;

    private MonthInputDTO(int month, String firstDayOfWeek) {
        this.month = month;
        this.firstDayOfWeek = firstDayOfWeek;
    }

    public static MonthInputDTO of(int month, String firstDayOfWeek) {
        return new MonthInputDTO(month, firstDayOfWeek);
    }

    public int getMonth() {
        return month;
    }

    public String getFirstDayOfWeek() {
        return firstDayOfWeek;
    }
}
