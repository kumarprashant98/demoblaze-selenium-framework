package phptravels;

import base.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import phptravelspageobjects.homepage.PHPHomePagePO;
import utilities.Constants;

public class SearchTripsTest extends BaseTest {
    //Test 1 : Verify that flights details are displayed
    @Test
    public void verifyThatFlightsDetailsAreDisplayedAfterClickingOnSearchButton() throws InterruptedException {
        PHPHomePagePO homepage = new PHPHomePagePO(driver);
        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.URLPT);

        Reporter.log("Step 2: Verify user navigated to home page");
        String headertext = "Your Trip Starts Here!";
        Assert.assertEquals(homepage.getHeaderText(), headertext, "Text not matched");

        Reporter.log("Step 3: Click on flights button");
        homepage.clickOnFlightsButton();

        Reporter.log("Step 4: Verify one way button is present");
        Assert.assertTrue(homepage.oneWayElementPresent(),"One way button not present");

        Reporter.log("Step 5: Click on one way button");
        homepage.clickOnOneWayButton();

        Reporter.log("Step 6: Click on flying from dropdown button");
        homepage.clickOnFlyingFromDropdown();

        Reporter.log("Step 7: Select from dropdown");
        String flyingCity = "BER";
        homepage.selectFromFlyingFromList(flyingCity);

        Reporter.log("Step 8: Click on destination from dropdown button");
        homepage.clickOnDestinationToDropdown();

        Reporter.log("Step 9: Select from dropdown");
        String destinationCity = "DEL";
        homepage.selectFromDestinationToList(destinationCity);

        Reporter.log("Step 10: Click on switch button");
        homepage.clickOnSwitchButton();

        Reporter.log("Step 11: Select Date from Calender");
        String Date = "29";
        homepage.selectDateFromCalender(Date);

        Reporter.log("Step 12: Click on Travellers dropdown");
        homepage.clickOnTravellers();

        Reporter.log("Step 13: Add traveller");
        homepage.addTravellers();

        Reporter.log("Step 14: Click on Search Button");
        homepage.clickOnSearchButton();

        Reporter.log("Step 15: Verify user navigated to flights page");
        Assert.assertTrue(homepage.isFlightsDisplayed(), "Flights data not displayed");

    }
}
