package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountInfoPage;
import pages.HomePage;
import pages.SignUpSuccessPage;
import pages.TopBar;
import utilities.BaseTest;
import utilities.CommonFlows;

public class SignUpTests extends BaseTest {
    private final AccountInfoPage accountInfoPage = new AccountInfoPage();
    private final SignUpSuccessPage signUpSuccessPage = new SignUpSuccessPage();
    private final HomePage homePage = new HomePage();
    private final TopBar topBar = new TopBar();
    private final CommonFlows commonFlows = new CommonFlows();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToAccountInfoPage();
    }

    @Test(groups = {regression, smoke})
    public void signUpTest() {
        accountInfoPage.fillAccountInfoForm(commonFlows.getUsername(), commonFlows.getEmail());

        signUpSuccessPage.waitPageLoad();
        signUpSuccessPage.verifyPage();
        signUpSuccessPage.clickContinue();

        homePage.waitPageLoad();
        topBar.waitPageLoad();
        topBar.verifyOpenedSession();
    }
}
