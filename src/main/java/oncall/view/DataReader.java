package oncall.view;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import oncall.dto.HolidayDTO;

public class DataReader {

    private static String MD_DELIMITER = ",";
    private static int INDEX_MONTH = 0;
    private static int INDEX_DATE = 1;

    public List<HolidayDTO> registerHolidays(String fileName) {
        ClassLoader classLoader = DataReader.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines()
                .skip(1)
                .map(this::parseHoliday)
                .map(lineSplit -> HolidayDTO.of(lineSplit.get(INDEX_MONTH), lineSplit.get(INDEX_DATE)))
                .toList();

    }

    private List<Integer> parseHoliday(String line) {
        return Arrays.stream(line.split(MD_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }
}
