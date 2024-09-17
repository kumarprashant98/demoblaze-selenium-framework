package demoblaze;

import base.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.homepage.HomePagePO;
import utilities.Constants;

public class NavigateToUrlTest extends BaseTest {
    // Test 1 : Verify that user is navigated to home page after entering URL
    @Test
    public void verifyThatUserIsNavigatedToHomePageAfterEnteringUrl() {
        HomePagePO homepage = new HomePagePO(driver);

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Verify that valid url is displayed");
        String url = "https://www.demoblaze.com/index.html";
        Assert.assertEquals(homepage.getCurrentUrl(), url, "Page url not matched");
    }
}
