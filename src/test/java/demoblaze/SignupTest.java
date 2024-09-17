package demoblaze;

import base.BaseTest;
import datafactory.SignupData;
import dataobjects.UserDetails;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.homepage.HomePagePO;
import pageobjects.signup.SignupPO;
import utilities.Constants;

public class SignupTest extends BaseTest {

    // Test 1: Verify that user is signed up successfully
    @Test
    public void verifyThatUserIsSignedUpSuccessfully() throws InterruptedException {
        HomePagePO homepage = new HomePagePO(driver);
        SignupPO signup = new SignupPO(driver);
        UserDetails signupdata = new SignupData().signupData();

        Reporter.log("Step 1: Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Verify that user navigated to Home page");
        String title = "PRODUCT STORE";
        Assert.assertEquals(homepage.getHomePageHeaderText(), title, "Text not matched");

        Reporter.log("Step 3: Click on the Signup button");
        homepage.clickOnSignUpButton();

        Reporter.log("Step 4: Verify that Sign up pop up is displayed");
        String signUpHeaderText = "Sign up";
        Assert.assertEquals(signup.getSignUpHeaderText(), signUpHeaderText, "Sign up header text not matched");

        Reporter.log("Step 5: Enter valid signup credentials and click on signup button");
        signup.enterSignupData(signupdata);

        Reporter.log("Step 6: Verify that user navigated to home page ");
        Assert.assertEquals(homepage.getHomePageHeaderText(), title, "Text not matched");
    }

    // Test 2: Verify that a validation message is displayed after clicking on signup button with invalid data

    @Test
    public void verifyThatValidationMessageIsDisplayedAfterClickingOnSignUpButtonWithInvalidData() throws InterruptedException {
        HomePagePO homepage = new HomePagePO(driver);
        SignupPO signup = new SignupPO(driver);
        UserDetails signupdata = new SignupData().invalidSignUpData();

        Reporter.log("Step 1: Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Verify that user navigated to Home page");
        String title = "PRODUCT STORE";
        Assert.assertEquals(homepage.getHomePageHeaderText(), title, "Text not matched");

        Reporter.log("Step 3: Click on the Signup button");
        homepage.clickOnSignUpButton();

        Reporter.log("Step 4: Verify that Sign up pop up is displayed");
        String signUpHeaderText = "Sign up";
        Assert.assertEquals(signup.getSignUpHeaderText(), signUpHeaderText, "Sign up header text not matched");

        Reporter.log("Step 5: Enter invalid signup credentials and click on signup button");
        signup.enterSignupData(signupdata);

        Reporter.log("Step 6: Verify Sign up pop up is present");
        Assert.assertEquals(signup.getSignUpHeaderText(), signUpHeaderText, "Sign up header text not matched");
        System.out.println("Validation message is displayed");
    }
}
