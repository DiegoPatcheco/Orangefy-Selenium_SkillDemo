package pages;

import io.qameta.allure.Step;
import models.FakeAccount;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.BasePage;

import java.io.File;
import java.time.Duration;

public class ContactPage extends BasePage {
    private final By contactUsTitle = By.xpath("//h2[text()='Contact ']");
    private final By nameInput = By.cssSelector("input[data-qa='name']");
    private final By emailInput = By.cssSelector("input[data-qa='email']");
    private final By subjectInput = By.cssSelector("input[data-qa='subject']");
    private final By messageInput = By.cssSelector("textarea[data-qa='message']");
    private final By uploadFileButton = By.cssSelector("input[type='file']");
    private final By submitButton = By.cssSelector("input[data-qa='submit-button']");
    private final By submitSuccessMessage = By.cssSelector("div[class$='alert-success']");

    @Override
    @Step("Waiting to contact us page to load")
    public void waitPageLoad() {
        waitPage(contactUsTitle, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verify contact us page web elements")
    public void verifyPage() {
        softAssert.assertTrue(find(contactUsTitle).isDisplayed());
        softAssert.assertTrue(find(nameInput).isDisplayed());
        softAssert.assertTrue(find(emailInput).isDisplayed());
        softAssert.assertTrue(find(subjectInput).isDisplayed());
        softAssert.assertTrue(find(messageInput).isDisplayed());
        softAssert.assertTrue(find(uploadFileButton).isDisplayed());
        softAssert.assertTrue(find(submitButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Fill contact form")
    public void fillContactForm() {
        final var fakeAccount = new FakeAccount();
        final var img = new File("src/test/resources/samples/pruebaFoto.png");

        find(nameInput).sendKeys(fakeAccount.getName());
        find(emailInput).sendKeys(fakeAccount.getEmail());
        find(subjectInput).sendKeys(fakeAccount.getSubject());
        find(messageInput).sendKeys(fakeAccount.getMessage());
        find(uploadFileButton).sendKeys(img.getAbsolutePath());
        find(submitButton).click();
    }

    @Step("Confirm success message")
    public void confirmSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

        final var confirm = (Alert) wait.until(ExpectedConditions.alertIsPresent());
        confirm.accept();

        Assert.assertEquals(find(submitSuccessMessage).getText(),
                "Success! Your details have been submitted successfully.");
    }
}
