package hw4.ex1;

import com.codeborne.selenide.SelenideElement;
import hw4.utils.AbstractSelenideTest;
import hw4.utils.ServiceHeaderItems;
import hw4.utils.ServiceLeftSideItems;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SelenideTest extends AbstractSelenideTest {

    @Test
    public void firstExerciseTest() {
        // 1. Open test site by URL
        open("https://epam.github.io/JDI/index.html");

        // 2. Assert Browser title
        HomePage homePage = new HomePage();
        assertEquals(title(), "Home Page");

        // 3. Perform login
        homePage.login(userProperties.getProperty("username"),
                userProperties.getProperty("password"));

        // 4. Assert User name in the left-top side
        // of screen that user is loggined
        homePage.usernameTextLabel().shouldHave(text("Piter Chailovskii"));

        // 5. Click on "Service" subcategory in the
        // header and check that drop down contains options
        homePage.headerDropDown().click();
        List<SelenideElement> actualServiceHeaderTexts =
                homePage.headerDropDownMenuItems();
        ServiceHeaderItems[] serviceHeaderItemsArray =
                ServiceHeaderItems.values();
        List<ServiceHeaderItems> expectedServiceHeaderItems =
                Arrays.asList(serviceHeaderItemsArray);
        for (int i = 0; i < actualServiceHeaderTexts.size(); i++) {
            actualServiceHeaderTexts.get(i).shouldHave(
                    text(expectedServiceHeaderItems.get(i).getItemName()));
        }

        // 6. Click on Service subcategory in the left
        // section and check that drop down contains options
        homePage.leftSideDropDown().click();
        List<SelenideElement> actualServiceLeftSideTexts =
                homePage.leftSideDropDownMenuItems();
        ServiceLeftSideItems[] serviceLeftSideItemsArray =
                ServiceLeftSideItems.values();
        List<ServiceLeftSideItems> expectedServiceLeftSideItems =
                Arrays.asList(serviceLeftSideItemsArray);
        for (int i = 0; i < actualServiceLeftSideTexts.size(); i++) {
            actualServiceLeftSideTexts.get(i).shouldHave(
                    text(expectedServiceLeftSideItems.get(i).getItemName()));
        }

        // 7. Open through the header menu Service -> Table with pages
        homePage.headerDropDown().click();
        homePage.clickItemInServiceHeader("TABLE WITH PAGES");

        // 8. Check that default value for “Show entries” dropdown is 5
        TableWithPagesPage tableWithPagesPage = page(TableWithPagesPage.class);
        tableWithPagesPage.tableWithPagesLength().
                getSelectedOption().shouldHave(text("5"));

        // 9. Assert that there is Right Section
        tableWithPagesPage.rightSection().shouldBe(visible);

        // 10. Assert that there is Left Section
        tableWithPagesPage.leftSection().shouldBe(visible);

        // 11. Select new value for the entries in the dropdown list
        tableWithPagesPage.tableWithPagesLength().selectOption("10");
        tableWithPagesPage.tableWithPagesLength().
                getSelectedOption().shouldHave(text("10"));

        // 12. Assert that for the dropdown there is an individual
        // log row and value is corresponded to the value of dropdown.
        List<SelenideElement> actualInfoPanelItems =
                tableWithPagesPage.infoPanelItems();
        boolean containsNeedableNumberOfElements = false;
        for (SelenideElement infoPanelItem : actualInfoPanelItems) {
            if (infoPanelItem.getText().contains("10")) {
                containsNeedableNumberOfElements = true;
                break;
            }
        }
        assertTrue(containsNeedableNumberOfElements);

        // 13. Assert that in the table displayed corrected amount of entries
        assertEquals(tableWithPagesPage.tableWithPagesRows().size(), 10);

        // 14. Type in “Search” text field
        tableWithPagesPage.typeSomeTextInSearchTextField("Custom");

        // 15. Assert the table contains only records with Search field value
        tableWithPagesPage.tableWithPagesBody();
        boolean containsNeedableSearchTextValue = true;
        for (SelenideElement rowItem :
                tableWithPagesPage.tableWithPagesRows()) {
            if (!rowItem.getText().contains("Custom")) {
                containsNeedableSearchTextValue = false;
                break;
            }
        }
        assertTrue(containsNeedableSearchTextValue);

        // X. Log out
        tableWithPagesPage.logout();
    }

}
