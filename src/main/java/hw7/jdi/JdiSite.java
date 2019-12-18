package hw7.jdi;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.jdi.entities.JdiUser;
import hw7.jdi.pages.JdiHomePage;
import hw7.jdi.pages.MetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("index.html")
    public static JdiHomePage jdiHomePage;

    @Url("metals-colors.html")
    public static MetalsColorsPage metalsColorsPage;

    public static void open() {
        jdiHomePage.open();
    }

    public static void login(JdiUser jdiUser) {
        jdiHomePage.login(jdiUser);
    }

    public static void openPageInHeaderMenu(String menuItem) {
        jdiHomePage.openPageInHeaderMenu(menuItem);
    }

}
