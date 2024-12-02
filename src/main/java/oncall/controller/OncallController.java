package oncall.controller;

import oncall.service.OncallService;
import oncall.view.DataReader;
import oncall.view.InputParser;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    OncallService service = new OncallService();
    InputParser parser = new InputParser();
    DataReader reader = new DataReader();

    public void run() {
        registerDays();
        registerWorkers();
        printResult();
    }

    private void registerDays() {
        retry(() -> {
            service.registerDays(
                    parser.parseMonthInput(inputView.getWorkingMonth()),
                    reader.readHolidays()
            );
        });
    }

    private void registerWorkers() {
        retry(() -> {
            service.registerWeekdayWorkers(parser.parseWorkersInput(inputView.getWeekdayWorkers()));
            service.registerHolidayWorkers(parser.parseWorkersInput(inputView.getHolidayWorkers()));
            service.validateWorkers();
        });
        service.assignWorkers();
    }

    private void printResult() {
        outputView.printResult(service.getResult());
    }

    private void retry(Runnable function) {
        while (true) {
            try {
                function.run();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printInvalidInput();
            }
        }
    }
}
