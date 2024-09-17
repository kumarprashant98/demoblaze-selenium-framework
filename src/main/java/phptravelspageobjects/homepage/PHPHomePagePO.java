package phptravelspageobjects.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import phptravelspageobjects.base.BasePO;

public class PHPHomePagePO extends BasePO {
    public PHPHomePagePO(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[data-bs-target='#tab-flights']")
    private WebElement flightsButton;

    @FindBy(css = "h4[class='text-white']")
    private WebElement headerText;

    @FindBy(css = "label[for='one-way']")
    private WebElement oneWayText;

    @FindBy(css = "input#one-way")
    private WebElement oneWayButton;

    @FindBy(css = "span[class='swap-places__arrow --bottom']")
    private WebElement switchButton;

    @FindBy(css = ".depart.form-control")
    private WebElement calenderClick;

    @FindBy(css = "button[id='flights-search']")
    private WebElement searchButton;

    @FindBy(css = "span[class='j_listABTit']")
    private WebElement totalFlights;
    @FindBy(xpath = "//label[text()='Flying From']/preceding-sibling::select[@data-select2-id='1']/following-sibling::span/descendant::span[@class='select2-selection__arrow']/child::b")
    private WebElement flyingFromDropdown;
    @FindBy(xpath = "//label[text()='Destination To']/preceding-sibling::select[@data-select2-id='4']/following-sibling::span/descendant::span[@class='select2-selection__arrow']/child::b")
    private WebElement destinationToDropdown;
    @FindBy(xpath = "//form[@id='flights-search']//a[contains(@class,'dropdown-btn travellers')]")
    private WebElement travellers;

    @FindBy(xpath = "//input[@id='fadults']/parent::div/child::div[@class='qtyInc']/*")
    private WebElement adultAddButton;

    /**
     * Click on one way button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnOneWayButton() throws InterruptedException {
        selenium.clickOn(oneWayButton);
    }

    /**
     * Click on flights button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnFlightsButton() throws InterruptedException {
        selenium.clickOn(flightsButton);
    }

    /**
     * Click on flying from dropdown button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnFlyingFromDropdown() throws InterruptedException {
        selenium.clickOn(flyingFromDropdown);
    }

    /**
     * Select from flying from dropdown list
     *
     * @param flyingCity name
     * @throws InterruptedException Exception
     */
    public void selectFromFlyingFromList(String flyingCity) throws InterruptedException {
        String xpath = "//button[text()='" + flyingCity + "']";
        selenium.clickOn(By.xpath(xpath));
    }

    /**
     * Click on destination to dropdown
     *
     * @throws InterruptedException Exception
     */
    public void clickOnDestinationToDropdown() throws InterruptedException {
        selenium.clickOn(destinationToDropdown);
    }

    /**
     * Select from Destination to dropdown list
     *
     * @param destinationCity name
     * @throws InterruptedException Exception
     */
    public void selectFromDestinationToList(String destinationCity) throws InterruptedException {
        String xpath = "//button[text()='" + destinationCity + "']";
        selenium.clickOn(By.xpath(xpath));
    }

    /**
     * Click on the switch button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnSwitchButton() throws InterruptedException {
        selenium.clickOn(switchButton);
    }

    /**
     * Get header text
     *
     * @return header text
     */
    public String getHeaderText() {
        return selenium.getText(headerText);
    }

    /**
     * Verify one way element present
     *
     * @return true or false
     */
    public boolean oneWayElementPresent() {
        return selenium.isElementPresent(oneWayText);
    }

    /**
     * Select date from calendar
     *
     * @param Date String
     * @throws InterruptedException Exception
     */
    public void selectDateFromCalender(String Date) throws InterruptedException {
        selenium.clickOn(calenderClick);
        String xpath = "//body[@id='fadein']//div[@class='datepicker dropdown-menu'][3]//td[text()='" + Date + "']";
        selenium.clickOn(By.xpath(xpath));
    }

    /**
     * Click on travellers dropdown
     *
     * @throws InterruptedException Exception
     */
    public void clickOnTravellers() throws InterruptedException {
        selenium.clickOn(travellers);
    }

    /**
     * Add travellers
     *
     * @throws InterruptedException Exception
     */
    public void addTravellers() throws InterruptedException {
        int index = selenium.getRandomNumber(2, 7);
        for (int i = 1; i < index; i++) {
            selenium.clickOn(adultAddButton);
        }
        selenium.clickOn(travellers);
    }

    /**
     * Click on the flight search button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnSearchButton() throws InterruptedException {
        selenium.clickOn(searchButton);
    }

    /**
     * Is flights displayed
     *
     * @return true or false
     */
    public boolean isFlightsDisplayed() {
        return selenium.isElementPresent(totalFlights);
    }

}




