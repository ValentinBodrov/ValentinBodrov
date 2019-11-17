package hw1;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {

    @DataProvider(name = "Sum Data Provider")
    public Object[][] sumTestDataProvider() {
        return new Object[][]{
                {2, 2, 4},
                {4, 7, 11},
                {-5, -1, -6}
        };
    }

    @DataProvider(name = "Substract Data Provider")
    public Object[][] subTestDataProvider() {
        return new Object[][]{
                {2, 2, 0},
                {4, 7, -3},
                {-5, -1, -4}
        };
    }

    @DataProvider(name = "Multiply Data Provider")
    public Object[][] multTestDataProvider() {
        return new Object[][]{
                {2, 3, 6},
                {4, 7, 28},
                {-5, -1, 5}
        };
    }

    @DataProvider(name = "Divide Data Provider")
    public Object[][] divTestDataProvider() {
        return new Object[][]{
                {10, 5, 2},
                {4, 1, 4},
                {-5, -1, 5}
        };
    }

    @DataProvider(name = "Sqrt Data Provider")
    public Object[][] sqrtTestDataProvider() {
        return new Object[][]{
                {9.0, 3.0},
                {1274.49, 35.7},
                {635.04, 25.2}
        };
    }

}
