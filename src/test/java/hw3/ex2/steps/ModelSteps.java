package hw3.ex2.steps;

import hw3.utils.ServiceHeaderItems;
import hw3.utils.ServiceLeftSideItems;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class ModelSteps extends AbstractSteps {

    public ModelSteps(WebDriver driver) {
        super(driver);
    }

    public ArrayList<String> getExpectedHeaderItems() {
        ArrayList<String> actualServiceHeaderItems = new ArrayList<>();
        for (ServiceHeaderItems item : ServiceHeaderItems.values()) {
            actualServiceHeaderItems.add(item.getItemName());
        }
        return actualServiceHeaderItems;
    }

    public ArrayList<String> getExpectedLeftSideItems() {
        ArrayList<String> actualServiceLeftSideItems = new ArrayList<>();
        for (ServiceLeftSideItems item : ServiceLeftSideItems.values()) {
            actualServiceLeftSideItems.add(item.getItemName());
        }
        return actualServiceLeftSideItems;
    }

}
