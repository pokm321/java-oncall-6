package oncall.controller;

import oncall.service.OncallService;
import oncall.view.InputParser;
import oncall.view.InputView;

public class OncallController {
    InputView inputView = new InputView();

    OncallService service = new OncallService();
    InputParser parser = new InputParser();

    public void run() {
        registerDays();
        //System.out.println(service.getMonth().getAllDays().get(1).getDayOfWeek());
    }

    private void registerDays() {
        service.registerDays(parser.parseMonthInput(inputView.getWorkingMonth()));
    }

    private void registerHolidays() {

    }

    private void registerWorkers() {

    }
}
