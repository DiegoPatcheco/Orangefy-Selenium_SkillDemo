package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;

public class TopBar extends BasePage {
    private final By mainTitle = By.cssSelector("img[alt='Website for automation practice']");
    private final By loginButton = By.cssSelector("a[href='/login']");
    private final By logoutButton = By.cssSelector("a[href='/logout']");
    private final By deleteAccountButton = By.cssSelector("a[href='/delete_account']");
    private final By productsButton = By.cssSelector("a[href='/products']");
    private final By cartButton = By.cssSelector("a[href='/view_cart']");
    private final By contactButton = By.cssSelector("a[href='/contact_us']");

    @Override
    @Step("Waiting for the TopBar")
    public void waitPageLoad() {
        waitPage(mainTitle, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verify TopBar web elements")
    public void verifyPage() {
        softAssert.assertTrue(find(loginButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Navigate to SignUp/Login page")
    public void clickLoginButton() {
        find(loginButton).click();
    }

    @Step("Verify opened session topbar")
    public void verifyOpenedSession() {
        softAssert.assertTrue(find(logoutButton).isDisplayed());
        softAssert.assertTrue(find(deleteAccountButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Navigate to cart page")
    public void clickCartButton() {
        find(cartButton).click();
    }

    @Step("Navigate to products page")
    public void clickProductsButton() {
        find(productsButton).click();
    }

    @Step("Navigate to contact page")
    public void clickContactButton() {
        find(contactButton).click();
    }
}
