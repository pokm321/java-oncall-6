package oncall.view;

import java.util.List;
import oncall.dto.ResultDTO;

public class OutputView {

    public void printInvalidInput() {
        System.out.println("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    }

    public void printResult(List<ResultDTO> resultDTOs) {
        resultDTOs.forEach(day -> {
            if (day.isHoliday() && !day.isWeekend()) {
                System.out.printf("%d월 %d일 %s(휴일) %s" + System.lineSeparator(), day.month(), day.date(),
                        day.dayOfWeek(), day.worker());
                return;
            }

            System.out.printf("%d월 %d일 %s %s" + System.lineSeparator(), day.month(), day.date(), day.dayOfWeek(),
                    day.worker());
        });
    }
}
