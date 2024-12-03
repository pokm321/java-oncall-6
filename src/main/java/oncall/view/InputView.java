package oncall.view;

import static oncall.view.Messages.INPUT_HOLIDAY;
import static oncall.view.Messages.INPUT_MONTH;
import static oncall.view.Messages.INPUT_WEEKDAY;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getWorkingMonth() {
        System.out.print(INPUT_MONTH.getMessage());
        return Console.readLine();
    }

    public String getWeekdayWorkers() {
        System.out.print(INPUT_WEEKDAY.getMessage());
        return Console.readLine();
    }

    public String getHolidayWorkers() {
        System.out.print(INPUT_HOLIDAY.getMessage());
        return Console.readLine();
    }
}
