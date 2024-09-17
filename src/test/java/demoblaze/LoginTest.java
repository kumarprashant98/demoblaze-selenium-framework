package demoblaze;

import base.BaseTest;
import datafactory.LoginData;
import dataobjects.UserDetails;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.homepage.HomePagePO;
import pageobjects.login.LoginPO;
import utilities.Constants;

public class LoginTest extends BaseTest {

    // Test 1: Verify that user can log in successfully

    @Test
    public void verifyThatUserIsLoggedInSuccessfully() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        HomePagePO homepage = new HomePagePO(driver);
        UserDetails logindata = new LoginData().loginData();

        Reporter.log("Step 1: Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Verify that user navigated to Home page");
        String title = "PRODUCT STORE";
        Assert.assertEquals(homepage.getHomePageHeaderText(), title, "Text not matched");

        Reporter.log("Step 3: Click on Log in button");
        homepage.clickOnLogInButton();

        Reporter.log("Step 4: Verify that Log in pop up is displayed");
        String logInHeaderText = "Log in";
        Assert.assertEquals(login.getLoginHeaderText(), logInHeaderText, "Log in title not matched");

        Reporter.log("Step 5: Enter valid login credentials and click on login button");
        String username = logindata.getUsername();
        String password = logindata.getPassword();
        login.enterLoginData(username, password);

        Reporter.log("Step 6: Verify that Log out button is displayed");
        String button = "Log out";
        Assert.assertEquals(homepage.getLogOutButtonText(), button, "Text not matched");
    }
}
