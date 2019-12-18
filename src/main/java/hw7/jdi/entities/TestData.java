package hw7.jdi.entities;

import java.util.Arrays;

public class TestData {

    private int[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    public int[] getSummary() {
        return summary;
    }

    public void setSummary(int[] summary) {
        this.summary = summary;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    public void setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
    }

    @Override
    public String toString() {
        String instanceToString = "";
        int[] summarySum = getSummary();
        int sum = 0;
        for (int current : summarySum) {
            sum += current;
        }
        instanceToString += "Summary: " + sum + "\n";

        String elementsList = Arrays.toString(getElements());
        elementsList = elementsList.replaceAll("\\[", "");
        elementsList = elementsList.replaceAll("]", "");
        instanceToString += "Elements: " + elementsList + "\n";
        instanceToString += "Color: " + getColor() + "\n";
        instanceToString += ("Metal: " + getMetals()) + "\n";
        String vegetablesList = Arrays.toString(getVegetables());
        vegetablesList = vegetablesList.replaceAll("\\[", "");
        vegetablesList = vegetablesList.replaceAll("]", "");
        instanceToString += "Vegetables: " + vegetablesList + "\n";

        return instanceToString;
    }
}
