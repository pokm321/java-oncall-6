package oncall.dto;

public class HolidayDTO {
    private final int month;
    private final int date;

    private HolidayDTO(int month, int date) {
        this.month = month;
        this.date = date;
    }

    public static HolidayDTO of(int month, int date) {
        return new HolidayDTO(month, date);
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }
}
