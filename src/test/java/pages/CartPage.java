package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;

public class CartPage extends BasePage {
    private final By emptyCartLabel = By.className("text-center");
    private final By shoppingCartTitle = By.className("active");
    private final By buyProductsLink = By.cssSelector("a[href='/products']");
    private final By itemsList = By.cssSelector("tr[id]");

    @Override
    @Step("Waiting to cart page to load")
    public void waitPageLoad() {
        waitPage(shoppingCartTitle, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verify cart page web elements")
    public void verifyPage() {
    }

    @Step("Go to buy products")
    public void clickBuyProductsLinkTest() {
        find(buyProductsLink).click();
    }

    @Step("Verify cart is empty")
    public void verifyCartEmpty() {
        softAssert.assertTrue(find(emptyCartLabel).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Verify total items added to cart")
    public void verifyTotalCartItems(int expectedTotalItems) {
        softAssert.assertEquals(findAll(itemsList).size(), expectedTotalItems);
        softAssert.assertAll();
    }
}
