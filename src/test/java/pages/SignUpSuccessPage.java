package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;

public class SignUpSuccessPage extends BasePage {
    private final By creationSuccessTitle = By.xpath("//b[text()='Account Created!']");
    private final By continueButton = By.cssSelector("a[data-qa='continue-button']");

    @Override
    @Step("Waiting for sign up success page to load")
    public void waitPageLoad() {
        waitPage(creationSuccessTitle, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verify sign up success web elements")
    public void verifyPage() {
        softAssert.assertTrue(find(creationSuccessTitle).isDisplayed());
        softAssert.assertTrue(find(continueButton).isEnabled());
        softAssert.assertTrue(find(continueButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Click on continue button")
    public void clickContinue() {
        find(continueButton).click();
    }
}
