package demoblaze;

import base.BaseTest;
import datafactory.PlaceOrderData;
import datafactory.SignupData;
import dataobjects.OrderDetails;
import dataobjects.UserDetails;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.cartpage.CartPagePO;
import pageobjects.homepage.HomePagePO;
import pageobjects.login.LoginPO;
import pageobjects.productpage.ProductPagePO;
import pageobjects.signup.SignupPO;
import utilities.Constants;

public class EndToEndTest extends BaseTest {

    // Test1 : Verify that product is purchased successfully
    @Test
    public void endToEndTest() throws InterruptedException {
        HomePagePO homepage = new HomePagePO(driver);
        SignupPO signup = new SignupPO(driver);
        LoginPO login = new LoginPO(driver);
        ProductPagePO productpage = new ProductPagePO(driver);
        CartPagePO cartpage = new CartPagePO(driver);
        UserDetails signupdata = new SignupData().signupData();
        OrderDetails placeorderdata = new PlaceOrderData().placeOrderData();

        Reporter.log("Step 1: Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Verify user navigated to home page");
        String title = "PRODUCT STORE";
        Assert.assertEquals(homepage.getHomePageHeaderText(), title, "Text not matched");

        Reporter.log("Step 3: Click on Sign up button");
        homepage.clickOnSignUpButton();

        Reporter.log("Step 4: Verify that Sign up pop up is displayed");
        String signupheader = "Sign up";
        Assert.assertEquals(signup.getSignUpHeaderText(), signupheader, "Text not matched");

        Reporter.log("Step 5 : Enter valid credentials and click on sign up button");
        signup.enterSignupData(signupdata);
        String username = signupdata.getUsername();
        String password = signupdata.getPassword();

        Reporter.log("Step 6: Click on Log in button");
        homepage.clickOnLogInButton();

        Reporter.log("Step 7: Verify that log in pop up is displayed");
        String loginheader = "Log in";
        Assert.assertEquals(login.getLoginHeaderText(), loginheader, "Text not matched");

        Reporter.log("Step 8: Enter valid credentials and click on log in button");
        login.enterLoginData(username, password);

        Reporter.log("Step 9: Verify that log out button is displayed");
        String logoutbutton = "Log out";
        Assert.assertEquals(homepage.getLogOutButtonText(), logoutbutton, "Text not matched");

        Reporter.log("Step 10: Click on phones category");
        String categoryname = "Phones";
        homepage.clickOnProductLink(categoryname);

        Reporter.log("Step 11: Click on product name");
        String productname = "Iphone 6 32gb";
        homepage.clickOnProductLink(productname);

        Reporter.log("Step 12: Verify that user navigated to Product page");
        Assert.assertEquals(productpage.getPageTitle(), productname, "Text not matched");

        Reporter.log("Step 13: Click on add to cart button");
        productpage.clickOnAddToCartButton();

        Reporter.log("Step 14: Click on Cart button");
        homepage.clickOnCartButton();

        Reporter.log("Step 15: Verify added product is displayed in cart");
        Assert.assertEquals(cartpage.getProductTitle(), productname, "Text not matched");

        Reporter.log("Step 16: Click on place order button");
        cartpage.clickOnPlaceOrderButton();

        Reporter.log("Step 17: Verify place order pop is displayed");
        Assert.assertTrue(cartpage.placeOrderDisplayed(), "Place order pop not displayed");

        Reporter.log("Step 18: Verify products total price with place order total ");
        Assert.assertEquals(cartpage.getProductsTotalPrice(), cartpage.getPlaceOrderTotalAmount(), "Price not matched");

        Reporter.log("Step 19: Enter valid data in the fields");
        cartpage.enterPlaceOrderData(placeorderdata);

        Reporter.log("Step 20: Click on purchase button");
        cartpage.clickOnPurchaseButton();

        Reporter.log("Step 21: Verify success message is displayed ");
        String successmessage = "Thank you for your purchase!";
        Assert.assertEquals(cartpage.getCheckOutSuccessMessage(), successmessage, "Text not Matched");

        Reporter.log("Step 22: Click on Ok button");
        cartpage.clickOnOkButton();

        Reporter.log("Step 23: Verify user navigated to home page");
        Assert.assertEquals(homepage.getHomePageHeaderText(), title, "Text not matched");
    }
}
