package oncall.dto;

public record HolidayDTO(int month, int date) {

    public static HolidayDTO of(int month, int date) {
        return new HolidayDTO(month, date);
    }
}
