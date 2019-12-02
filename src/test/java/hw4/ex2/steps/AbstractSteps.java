package hw4.ex2.steps;

import hw4.ex1.HomePage;
import hw4.ex2.MetalsAndColorsPage;

import static com.codeborne.selenide.Selenide.page;

public abstract class AbstractSteps {

    protected HomePage homePage;
    protected MetalsAndColorsPage metalsAndColorsPage;

    public AbstractSteps() {
    }

    public HomePage initHomePage() {
        return new HomePage();
    }

    public MetalsAndColorsPage initMetalsAndColorsPage() {
        return page(MetalsAndColorsPage.class);
    }

}
