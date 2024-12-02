package oncall.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import oncall.dto.MonthInputDTO;
import oncall.view.DataReader;
import org.junit.jupiter.api.Test;

public class MonthTest {
    DataReader reader = new DataReader();

    @Test
    void 객체_생성_테스트() {
        Month month = Month.from(MonthInputDTO.of(8, "화"), reader.readHolidays());
        assertThat(month.getAllDays().size()).isEqualTo(31);

        Day firstDay = month.getAllDays().get(0);
        assertThat(firstDay.getMonth()).isEqualTo(8);
        assertThat(firstDay.getDate()).isEqualTo(1);
        assertThat(firstDay.getDayOfWeek()).isEqualTo("화");
        assertThat(firstDay.getHoliday()).isEqualTo(false);

        Day secondDay = month.getAllDays().get(1);
        assertThat(secondDay.getMonth()).isEqualTo(8);
        assertThat(secondDay.getDate()).isEqualTo(2);
        assertThat(secondDay.getDayOfWeek()).isEqualTo("수");
        assertThat(secondDay.getHoliday()).isEqualTo(false);

        Day fifteenthDay = month.getAllDays().get(14);
        assertThat(fifteenthDay.getMonth()).isEqualTo(8);
        assertThat(fifteenthDay.getDate()).isEqualTo(15);
        assertThat(fifteenthDay.getDayOfWeek()).isEqualTo("화");
        assertThat(fifteenthDay.getHoliday()).isEqualTo(true);

        Day lastDay = month.getAllDays().get(30);
        assertThat(lastDay.getMonth()).isEqualTo(8);
        assertThat(lastDay.getDate()).isEqualTo(31);
        assertThat(lastDay.getDayOfWeek()).isEqualTo("목");
        assertThat(lastDay.getHoliday()).isEqualTo(false);

        assertThatThrownBy(() -> month.getAllDays().get(31)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
