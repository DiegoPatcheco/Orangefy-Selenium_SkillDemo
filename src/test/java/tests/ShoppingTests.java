package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import pages.TopBar;
import utilities.BaseTest;
import utilities.CommonFlows;

public class ShoppingTests extends BaseTest {
    private final CommonFlows commonFlows = new CommonFlows();
    private final CartPage cartPage = new CartPage();
    private final ProductsPage productsPage = new ProductsPage();
    private final TopBar topBar = new TopBar();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.loginToHomePage();
    }

    @Test(groups = {regression, smoke})
    public void verifyEmptyCartTest() {
        topBar.clickCartButton();
        cartPage.waitPageLoad();
        cartPage.verifyCartEmpty();
        cartPage.clickBuyProductsLinkTest();
        productsPage.waitPageLoad();
    }

    @Test(groups = {regression, smoke})
    public void addingProductsCartTest() {
        int products = 3;

        topBar.clickProductsButton();
        productsPage.waitPageLoad();
        productsPage.addingProducts(products);
        topBar.clickCartButton();
        cartPage.waitPageLoad();
        cartPage.verifyTotalCartItems(products);
    }

    @Test(groups = {regression, smoke})
    public void verifyProductsPageTest() {
        topBar.clickProductsButton();
        productsPage.waitPageLoad();
        productsPage.verifyPage();
    }

    /*@Test(groups = {regression, smoke}, dataProviderClass = CustomDataProviders.class, dataProvider = CustomDataProviders.DP_ITEM)
    public void verifyItemPriceTest(Item item) {
        topBar.clickProductsButton();
        productsPage.waitPageLoad();
        productsPage.verifyItemsPrice(item);
    }*/
}
