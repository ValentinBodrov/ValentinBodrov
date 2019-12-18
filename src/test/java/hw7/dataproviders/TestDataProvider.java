package hw7.dataproviders;

import hw7.jdi.entities.TestData;
import org.testng.annotations.DataProvider;

import java.util.Map;

public class TestDataProvider {

    @DataProvider(name = "Data Sets Provider")
    public Object[] getData() {
        TestDataGetter testDataGetter = new TestDataGetter();
        Map<String, TestData> testDataArray = testDataGetter.getTestData();
        return new Object[]{
                testDataArray.get("data_1"),
                testDataArray.get("data_2"),
                testDataArray.get("data_3"),
                testDataArray.get("data_4"),
                testDataArray.get("data_5")
        };
    }

}
