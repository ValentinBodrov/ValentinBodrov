package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultTest extends AbstractBaseTest {

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Multiply Data Provider")
    public void multTest(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }

}
