package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;

public class HomePage extends BasePage {
    private final By slider = By.id("slider");

    @Override
    @Step("Waiting for home page to load")
    public void waitPageLoad() {
        waitPage(slider, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {

    }
}
