package hw4.utils;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class TestDataProvider {

    @DataProvider(name = "Data Sets Provider")
    public Object[][] dataSetsProvider() {
        return new Object[][]{
                {TestData.testDataBuilder().
                        setElements(Arrays.asList("Earth")).
                        setColors("Yellow").
                        setMetals("Gold").
                        build()},
                {TestData.testDataBuilder().
                        setSummary(Arrays.asList(3, 8)).
                        setVegetables(Arrays.asList("Cucumber", "Tomato")).
                        build()},
                {TestData.testDataBuilder().
                        setSummary(Arrays.asList(3, 2)).
                        setElements(Arrays.asList("Water", "Wind", "Fire")).
                        setMetals("Bronze").
                        setVegetables(Arrays.asList("Onion")).
                        build()},
                {TestData.testDataBuilder().
                        setSummary(Arrays.asList(6, 5)).
                        setElements(Arrays.asList("Water")).
                        setColors("Green").
                        setMetals("Selen").
                        setVegetables(Arrays.asList("Cucumber",
                                "Tomato", "Vegetables", "Onion")).
                        build()},
                {TestData.testDataBuilder().
                        setElements(Arrays.asList("Fire")).
                        setColors("Blue").
                        setVegetables(Arrays.asList("Cucumber",
                                "Tomato", "Vegetables")).
                        build()},
        };
    }
}
