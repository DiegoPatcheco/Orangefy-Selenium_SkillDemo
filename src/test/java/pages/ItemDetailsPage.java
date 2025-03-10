package pages;

import io.qameta.allure.Step;
import models.FakeAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.BasePage;

public class ItemDetailsPage extends BasePage {
    private final By itemTitle = By.xpath("//h2[text()='Blue Top']");
    private final By itemDescription = By.xpath("//p[text()='Category: Women > Tops']");
    private final By itemRating = By.cssSelector("img[src='/static/images/product-details/rating.png']");
    private final By itemPrice = By.xpath("//span[text()='Rs. 500']");
    private final By itemQuantityLabel = By.xpath("//label[text()='Quantity:']");
    private final By itemAddCartButton = By.cssSelector("button[class$='cart']");
    private final By itemAvailabilityLabel = By.xpath("//b[text()='Availability:']");
    private final By itemConditionLabel = By.xpath("//b[text()='Condition:']");
    private final By itemBrandLabel = By.xpath("//b[text()='Brand:']");
    private final By writeReviewTitle = By.cssSelector("a[href='#reviews']");
    private final By nameReviewInput = By.id("name");
    private final By emailReviewInput = By.id("email");
    private final By messageReviewInput = By.id("review");
    private final By submitReviewButton = By.id("button-review");
    private final By submitSuccessMessage = By.cssSelector("div[class^='alert-success']");

    @Override
    @Step("Waiting for item details page to load")
    public void waitPageLoad() {
        waitPage(writeReviewTitle, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verify item details web elements")
    public void verifyPage() {
        softAssert.assertTrue(find(itemTitle).isDisplayed());
        softAssert.assertTrue(find(itemDescription).isDisplayed());
        softAssert.assertTrue(find(itemRating).isDisplayed());
        softAssert.assertTrue(find(itemPrice).isDisplayed());
        softAssert.assertTrue(find(itemQuantityLabel).isDisplayed());
        softAssert.assertTrue(find(itemAddCartButton).isDisplayed());
        softAssert.assertTrue(find(itemAvailabilityLabel).isDisplayed());
        softAssert.assertTrue(find(itemConditionLabel).isDisplayed());
        softAssert.assertTrue(find(itemBrandLabel).isDisplayed());
        softAssert.assertTrue(find(writeReviewTitle).isDisplayed());
        softAssert.assertTrue(find(nameReviewInput).isDisplayed());
        softAssert.assertTrue(find(emailReviewInput).isDisplayed());
        softAssert.assertTrue(find(messageReviewInput).isDisplayed());
        softAssert.assertTrue(find(submitReviewButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Submit item review")
    public void submitItemReview() {
        final var fakeAccount = new FakeAccount();

        new Actions(getDriver()).scrollToElement(find(submitReviewButton)).perform();

        find(nameReviewInput).sendKeys(fakeAccount.getName());
        find(emailReviewInput).sendKeys(fakeAccount.getEmail());
        find(messageReviewInput).sendKeys(fakeAccount.getMessage());
        find(submitReviewButton).click();
    }

    @Step("Verify submit success message")
    public void verifySubmitSuccessMessage() {
        softAssert.assertEquals(find(submitSuccessMessage).getText(), "Thank you for your review.");
        softAssert.assertAll();
    }
}
