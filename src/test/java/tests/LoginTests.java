package tests;

import data.DataGiver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.TopBar;
import utilities.BaseTest;
import utilities.CommonFlows;

public class LoginTests extends BaseTest {
    private final CommonFlows commonFlows = new CommonFlows();
    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();
    private final TopBar topBar = new TopBar();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToLoginPage();
    }

    @Test(groups = {regression, smoke})
    public void verifyLoginElementsTest() {
        loginPage.verifyPage();
    }

    @Test(groups = {regression, smoke})
    public void loginValidCredentialsTest() {
        final var validCredentials = DataGiver.getValidCredentials();

        loginPage.fillLoginForm(validCredentials.getEmail(), validCredentials.getPassword());
        homePage.waitPageLoad();
        topBar.verifyOpenedSession();
    }
}
