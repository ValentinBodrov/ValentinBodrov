package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSqrtTest extends AbstractBaseTest {

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Sqrt Data Provider")
    public void sqrtTest(double a, double expected) {
        double actual = calculator.sqrt(a);
        assertEquals(actual, expected);
    }

}
