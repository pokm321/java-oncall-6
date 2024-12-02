package oncall.service;

import oncall.dto.MonthInputDTO;
import oncall.model.Month;

public class OncallService {

    private Month month;

    public void registerDays(MonthInputDTO monthInputDTO) {
        month = Month.from(monthInputDTO);
    }

    public Month getMonth() {
        return month;
    }
}
