package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractBaseTest {
    protected Calculator calculator;

    @BeforeMethod
    public void setUp() {
        this.calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        this.calculator = null;
    }
}
