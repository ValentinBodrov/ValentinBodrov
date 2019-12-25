package hw7.jdi.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import hw7.jdi.entities.JdiUser;
import hw7.jdi.forms.LoginForm;

public class JdiHomePage extends WebPage {

    public LoginForm loginForm;

    @Css("#user-name")
    private Text userName;

    @Css("#user-icon")
    private Button userIcon;

    @Css(".nav")
    private Menu headerMenu;

    public String getUserName() {
        return userName.getText();
    }

    public void login(JdiUser jdiUser) {
        userIcon.click();
        loginForm.login(jdiUser);
    }

    public void openPageInHeaderMenu(String menuItem) {
        headerMenu.select(menuItem);
    }

}
