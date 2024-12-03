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

        assertThat(holidays.get(0).month()).isEqualTo(1);
        assertThat(holidays.get(0).date()).isEqualTo(1);

        assertThat(holidays.get(1).month()).isEqualTo(3);
        assertThat(holidays.get(1).date()).isEqualTo(1);

        assertThat(holidays.get(2).month()).isEqualTo(5);
        assertThat(holidays.get(2).date()).isEqualTo(5);
    }
}
