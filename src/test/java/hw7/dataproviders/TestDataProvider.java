package hw7.dataproviders;

import hw7.jdi.entities.MetalsAndColorsFormFiller;
import org.testng.annotations.DataProvider;

import java.util.Map;

public class TestDataProvider {

    @DataProvider(name = "Data Sets Provider")
    public Object[] getData() {
        return TestDataGetter.getTestData();
    }

}
