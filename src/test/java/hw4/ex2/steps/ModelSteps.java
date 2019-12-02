package hw4.ex2.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.utils.TestData;

import java.util.ArrayList;
import java.util.List;

public class ModelSteps extends AbstractSteps {

    public ArrayList<String> getActualResultSet(ElementsCollection resultPanel, TestData dataSet) {
        ArrayList<String> actualResultSet = new ArrayList<>();
        for (SelenideElement result : resultPanel) {
            if (result.getText().contains("Summary:") && dataSet.getSummary() == null) {
                continue;
            }
            if (result.getText().contains("Elements:") && dataSet.getElements() == null) {
                continue;
            }
            if (result.getText().contains("Color:") && dataSet.getColors() == null) {
                continue;
            }
            if (result.getText().contains("Metal:") && dataSet.getMetals() == null) {
                continue;
            }
            if (result.getText().contains("Vegetables:") && dataSet.getVegetables() == null) {
                continue;
            }
            actualResultSet.add(result.getText());
        }
        return actualResultSet;
    }

    public ArrayList<String> getExpectedResultSet(TestData dataSet) {
        ArrayList<String> expectedResultSet = new ArrayList<>();
        if (dataSet.getSummary() != null) {
            List<Integer> summarySum = dataSet.getSummary();
            int sum = 0;
            for (Integer current : summarySum) {
                sum += current;
            }
            expectedResultSet.add("Summary: " + sum);
        }
        if (dataSet.getElements() != null) {
            String elementsList = dataSet.getElements().toString();
            elementsList = elementsList.replaceAll("\\[", "");
            elementsList = elementsList.replaceAll("]", "");
            expectedResultSet.add("Elements: " + elementsList);
        }
        if (dataSet.getColors() != null) {
            expectedResultSet.add("Color: " + dataSet.getColors());
        }
        if (dataSet.getMetals() != null) {
            expectedResultSet.add("Metal: " + dataSet.getMetals());
        }
        if (dataSet.getVegetables() != null) {
            String vegetablesList = dataSet.getVegetables().toString();
            vegetablesList = vegetablesList.replaceAll("\\[", "");
            vegetablesList = vegetablesList.replaceAll("]", "");
            expectedResultSet.add("Vegetables: " + vegetablesList);
        }
        return expectedResultSet;
    }

}
