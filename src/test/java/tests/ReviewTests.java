package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ItemDetailsPage;
import utilities.BaseTest;
import utilities.CommonFlows;

public class ReviewTests extends BaseTest {
    private final CommonFlows commonFlows = new CommonFlows();
    private final ItemDetailsPage itemDetailsPage = new ItemDetailsPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToItemDetailsPage();
    }

    @Test(groups = {regression, smoke})
    public void verifyItemDetailsPageTest() {
        itemDetailsPage.verifyPage();
    }

    @Test(groups = {regression, smoke})
    public void submitItemReviewTest() {
        itemDetailsPage.submitItemReview();
        itemDetailsPage.verifySubmitSuccessMessage();
    }
}
