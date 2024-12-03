package oncall.view;

import static oncall.view.Messages.OUTPUT_ERROR;
import static oncall.view.Messages.OUTPUT_FORMAT_HOLIDAY;
import static oncall.view.Messages.OUTPUT_FORMAT_WEEKDAY;

import java.util.List;
import oncall.dto.ResultDTO;

public class OutputView {

    public void printInvalidInput() {
        System.out.println(OUTPUT_ERROR.getMessage());
    }

    public void printResult(List<ResultDTO> resultDTOs) {
        resultDTOs.forEach(day -> {
            if (day.isHoliday() && !day.isWeekend()) {
                System.out.printf(OUTPUT_FORMAT_HOLIDAY.getMessage(),
                        day.month(), day.date(), day.dayOfWeek(), day.worker());
                return;
            }

            System.out.printf(OUTPUT_FORMAT_WEEKDAY.getMessage(),
                    day.month(), day.date(), day.dayOfWeek(), day.worker());
        });
    }
}
