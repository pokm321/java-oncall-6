package oncall.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import oncall.dto.MonthInputDTO;
import org.junit.jupiter.api.Test;

public class MonthTest {

    @Test
    void 객체_생성_테스트() {
        Month month = Month.from(MonthInputDTO.of(2, "화"));
        assertThat(month.getAllDays().size()).isEqualTo(28);

        Day firstDay = month.getAllDays().get(0);
        assertThat(firstDay.getMonth()).isEqualTo(2);
        assertThat(firstDay.getDate()).isEqualTo(1);
        assertThat(firstDay.getDayOfWeek()).isEqualTo("화");

        Day secondDay = month.getAllDays().get(1);
        assertThat(secondDay.getMonth()).isEqualTo(2);
        assertThat(secondDay.getDate()).isEqualTo(2);
        assertThat(secondDay.getDayOfWeek()).isEqualTo("수");

        Day eleventhDay = month.getAllDays().get(10);
        assertThat(eleventhDay.getMonth()).isEqualTo(2);
        assertThat(eleventhDay.getDate()).isEqualTo(11);
        assertThat(eleventhDay.getDayOfWeek()).isEqualTo("금");

        Day lastDay = month.getAllDays().get(27);
        assertThat(lastDay.getMonth()).isEqualTo(2);
        assertThat(lastDay.getDate()).isEqualTo(28);
        assertThat(lastDay.getDayOfWeek()).isEqualTo("월");

        assertThatThrownBy(() -> month.getAllDays().get(28)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
