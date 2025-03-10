package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactPage;
import utilities.BaseTest;
import utilities.CommonFlows;

public class ContactTests extends BaseTest {
    private final CommonFlows commonFlows = new CommonFlows();
    private final ContactPage contactPage = new ContactPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToContactPage();
    }

    @Test(groups = {regression, smoke})
    public void verifyContactPageTest() {
        contactPage.verifyPage();
    }

    @Test(groups = {regression, smoke})
    public void submitContactMessageTest() {
        contactPage.fillContactForm();
        contactPage.confirmSuccessMessage();
    }
}
