package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage {
    private final By emptyCartLabel = By.id("empty_cart");
    private final By shoppingCartTitle = By.className("active");
    private final By buyProductsLink = By.cssSelector("a[href='/products']");
    private final By itemsList = By.cssSelector("tr[id]");
    private List<WebElement> itemsLocatorList;

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
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        itemsLocatorList = findAll(itemsList);

        if (!itemsLocatorList.isEmpty()) {
            for (var i = 1; i < itemsLocatorList.size() + 1; i++) {
                find(removeItemButtonDynamicLocator(i)).click();
            }
        }

        final var label = wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartLabel));
        softAssert.assertTrue(label.isDisplayed());
        softAssert.assertAll();
    }

    @Step("Verify total items added to cart")
    public void verifyTotalCartItems(int expectedTotalItems) {
        softAssert.assertEquals(findAll(itemsList).size(), expectedTotalItems);
        softAssert.assertAll();
    }

    private By removeItemButtonDynamicLocator(int itemId) {
        return By.cssSelector(String.format("a[data-product-id='%d']", itemId));
    }
}
