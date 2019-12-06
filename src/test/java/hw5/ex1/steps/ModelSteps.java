package hw5.ex1.steps;

import hw5.utils.HeaderItems;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModelSteps extends AbstractSteps {

    public ModelSteps(WebDriver driver) {
        super(driver);
    }

    public ArrayList<String> getExpectedHeaderItems() {
        ArrayList<String> actualHeaderItems = new ArrayList<>();
        for (HeaderItems item : HeaderItems.values()) {
            actualHeaderItems.add(item.getItemName());
        }
        return actualHeaderItems;
    }

    public List<String> getExpectedBenefitsTexts() {
        return Arrays.asList(
                "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project",
                "To be flexible and\n" +
                        "customizable",
                "To be multiplatform",
                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");
    }

    public String getExpectedMainHeader() {
        return "EPAM FRAMEWORK WISHES…";
    }

    public String getExpectedMainText() {
        String expectedMainText = "Lorem ipsum dolor sit amet, consectetur" +
                " adipisicing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua. Ut enim ad " +
                "minim veniam, quis nostrud exercitation " +
                "ullamco laboris nisi ut aliquip ex ea commodo consequat " +
                "Duis aute irure dolor in reprehenderit in " +
                "voluptate velit esse cillum dolore eu fugiat nulla pariatur.";
        expectedMainText = expectedMainText.toUpperCase();
        return expectedMainText;
    }

}
