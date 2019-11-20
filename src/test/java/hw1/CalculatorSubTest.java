package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubTest extends AbstractBaseTest {

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Substract Data Provider")
    public void subTest(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

}
