package oncall.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import oncall.dto.HolidayDTO;
import oncall.dto.MonthInputDTO;
import oncall.dto.ResultDTO;
import oncall.dto.WorkersDTO;
import oncall.model.Day;
import oncall.model.Month;
import oncall.model.Workers;

public class OncallService {

    private Month month;
    private Workers weekdayWorkers;
    private Workers holidayWorkers;

    public void registerDays(MonthInputDTO monthInputDTO, List<HolidayDTO> holidayDTOs) {
        this.month = Month.from(monthInputDTO, holidayDTOs);
    }

    public void registerWeekdayWorkers(WorkersDTO weekdayWorkers) {
        this.weekdayWorkers = Workers.of(weekdayWorkers.workers());
    }

    public void registerHolidayWorkers(WorkersDTO holidayWorkers) {
        this.holidayWorkers = Workers.of(holidayWorkers.workers());
    }

    public void validateWorkers() {
        if (weekdayWorkers.getNames().stream()
                .anyMatch(weekdayWorker -> !holidayWorkers.getNames().contains(weekdayWorker))) {
            throw new IllegalArgumentException();
        }
    }

    public void assignWorkers() {
        String lastWorker = "";
        List<String> weekdayWorkerNames = new ArrayList<>(weekdayWorkers.getNames());
        List<String> holidayWorkerNames = new ArrayList<>(holidayWorkers.getNames());

        for (Day day : month.getAllDays()) {
            if (day.isHoliday() || day.isWeekend()) {
                swapWorker(lastWorker, holidayWorkerNames);
                lastWorker = assignWorker(day, holidayWorkerNames);
                continue;
            }

            swapWorker(lastWorker, weekdayWorkerNames);
            lastWorker = assignWorker(day, weekdayWorkerNames);
        }
    }

    private void swapWorker(String lastWorker, List<String> workerNames) {
        if (workerNames.get(0).equals(lastWorker)) {
            Collections.swap(workerNames, 0, 1);
        }
    }

    private String assignWorker(Day day, List<String> workerNames) {
        String worker = workerNames.get(0);
        day.setWorker(worker);
        workerNames.remove(worker);
        workerNames.add(worker);

        return worker;
    }


    public List<ResultDTO> getResult() {
        return month.getAllDays().stream()
                .map(day -> ResultDTO.of(
                        day.getMonth(),
                        day.getDate(),
                        day.isHoliday(),
                        day.isWeekend(),
                        day.getDayOfWeek(),
                        day.getWorker()
                ))
                .toList();
    }
}
