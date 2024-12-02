package oncall.view;

import java.util.List;
import oncall.dto.MonthInputDTO;
import oncall.dto.WorkersDTO;

public class InputParser {

    private static final String INPUT_DELIMITER = ",";
    private static final int VALUE_COUNT_MONTH_INPUT = 2;

    public MonthInputDTO parseMonthInput(String monthInput) {
        List<String> inputSplit = List.of(monthInput.split(INPUT_DELIMITER, VALUE_COUNT_MONTH_INPUT));

        if (inputSplit.size() != VALUE_COUNT_MONTH_INPUT) {
            throw new IllegalArgumentException();
        }

        try {
            return MonthInputDTO.of(Integer.parseInt(inputSplit.get(0)), inputSplit.get(1));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public WorkersDTO parseWorkersInput(String workersInput) {
        return WorkersDTO.of(List.of(workersInput.split(INPUT_DELIMITER)));
    }
}
