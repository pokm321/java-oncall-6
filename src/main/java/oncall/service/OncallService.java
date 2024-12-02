package oncall.service;

import java.util.List;
import oncall.dto.HolidayDTO;
import oncall.dto.MonthInputDTO;
import oncall.model.Month;
import oncall.view.DataReader;

public class OncallService {
    DataReader dataReader = new DataReader();

    private Month month;

    public void registerDays(MonthInputDTO monthInputDTO, List<HolidayDTO> holidayDTOs) {
        month = Month.from(monthInputDTO, holidayDTOs);
    }

    public Month getMonth() {
        return month;
    }
}
