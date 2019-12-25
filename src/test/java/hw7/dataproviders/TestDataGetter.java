package hw7.dataproviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw7.jdi.entities.MetalsAndColorsFormFiller;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class TestDataGetter {

    public static Object[] getTestData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (FileReader fileReader = new FileReader(
                "src/test/resources/hw7/JDI_ex8_metalsColorsDataSet.json")) {
            Map<String, MetalsAndColorsFormFiller> testDataMap = objectMapper.
                    readValue(fileReader, new TypeReference<Map<String,
                            MetalsAndColorsFormFiller>>() {
                    });
            return testDataMap.values().toArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
