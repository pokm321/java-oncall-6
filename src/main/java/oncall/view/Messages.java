package oncall.view;

public enum Messages {

    INPUT_MONTH("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
    INPUT_WEEKDAY("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    INPUT_HOLIDAY("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),

    OUTPUT_ERROR("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    OUTPUT_FORMAT_HOLIDAY("%d월 %d일 %s(휴일) %s" + System.lineSeparator()),
    OUTPUT_FORMAT_WEEKDAY("%d월 %d일 %s %s" + System.lineSeparator()),
    ;

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
