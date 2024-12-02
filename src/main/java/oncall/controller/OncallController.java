package oncall.controller;

import oncall.service.OncallService;
import oncall.view.DataReader;
import oncall.view.InputParser;
import oncall.view.InputView;

public class OncallController {
    InputView inputView = new InputView();
    OncallService service = new OncallService();
    InputParser parser = new InputParser();
    DataReader reader = new DataReader();

    public void run() {
        registerDays();

    }

    private void registerDays() {
        service.registerDays(parser.parseMonthInput(inputView.getWorkingMonth()), reader.readHolidays());
    }

    private void registerHolidays() {

    }

    private void registerWorkers() {

    }
}
