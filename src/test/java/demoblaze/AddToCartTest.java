package demoblaze;

import base.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.cartpage.CartPagePO;
import pageobjects.homepage.HomePagePO;
import pageobjects.productpage.ProductPagePO;
import utilities.Constants;

public class AddToCartTest extends BaseTest {
    // Test 1 : Verify that product is added to cart successfully
    @Test
    public void verifyThatProductIsAddedToCartSuccessfully() throws InterruptedException {
        HomePagePO homepage = new HomePagePO(driver);
        ProductPagePO productpage = new ProductPagePO(driver);
        CartPagePO cartpage = new CartPagePO(driver);

        Reporter.log("Step 1: Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Verify that user navigated to home page");
        String title = "PRODUCT STORE";
        Assert.assertEquals(homepage.getHomePageHeaderText(), title, "Text not matched");

        Reporter.log("Step 3: Click on the Phones category");
        String categoryName = "Phones";
        homepage.clickOnProductLink(categoryName);

        Reporter.log("Step 4: Click on the product name");
        String productName = "Samsung galaxy s6";
        homepage.clickOnProductLink(productName);

        Reporter.log("Step 5: Verify user navigated to product page");
        Assert.assertEquals(productpage.getPageTitle(), productName, "Product name not matched");

        Reporter.log("Step 6: Click on Add to cart button");
        productpage.clickOnAddToCartButton();

        Reporter.log("Step 7: Click on Cart button");
        homepage.clickOnCartButton();

        Reporter.log("Step 8 : Verify added product is displayed in cart");
        Assert.assertEquals(cartpage.getProductTitle(), productName, "Product title not matched");
    }
}
