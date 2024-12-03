package oncall.dto;

public record MonthInputDTO(int month, String firstDayOfWeek) {

    public static MonthInputDTO of(int month, String firstDayOfWeek) {
        return new MonthInputDTO(month, firstDayOfWeek);
    }
}
