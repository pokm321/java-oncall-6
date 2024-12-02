package oncall.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import oncall.dto.HolidayDTO;
import org.junit.jupiter.api.Test;

public class DataReaderTest {
    DataReader reader = new DataReader();

    @Test
    void 휴일_생성_테스트() {
        List<HolidayDTO> holidays = reader.readHolidays();

        assertThat(holidays.get(0).getMonth()).isEqualTo(1);
        assertThat(holidays.get(0).getDate()).isEqualTo(1);

        assertThat(holidays.get(1).getMonth()).isEqualTo(3);
        assertThat(holidays.get(1).getDate()).isEqualTo(1);

        assertThat(holidays.get(2).getMonth()).isEqualTo(5);
        assertThat(holidays.get(2).getDate()).isEqualTo(5);
    }
}
