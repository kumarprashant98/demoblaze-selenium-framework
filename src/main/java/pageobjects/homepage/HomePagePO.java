package pageobjects.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class HomePagePO extends BasePO {

    public HomePagePO(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "logout2")
    private WebElement logOutButton;

    @FindBy(xpath = "//a[@id='nava']")
    private WebElement homePageHeaderText;

    @FindBy(id = "signin2")
    private WebElement signUpButton;
    @FindBy(id = "login2")
    private WebElement logInButton;
    @FindBy(id = "cartur")
    private WebElement cartButton;

    /**
     * Click on the Login button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnLogInButton() throws InterruptedException {
        selenium.clickOn(logInButton);
    }

    /**
     * Click on the Signup button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnSignUpButton() throws InterruptedException {
        selenium.clickOn(signUpButton);
    }

    /**
     * Click on Cart button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnCartButton() throws InterruptedException {
        selenium.clickOn(cartButton);
    }

    /**
     * Click on Product link text
     *
     * @param productDetails data
     * @throws InterruptedException Exception
     */
    public void clickOnProductLink(String productDetails) throws InterruptedException {
        String xpath = "//a[text()='" + productDetails + "']";
        selenium.clickOn(By.xpath(xpath));
    }

    /**
     * Get LogOut button text
     *
     * @return Logout button text
     */
    public String getLogOutButtonText() {
        return selenium.getText(logOutButton);
    }

    /**
     * Get Home page header text
     *
     * @return home page header text
     */
    public String getHomePageHeaderText() {
        return selenium.getText(homePageHeaderText);
    }

    /**
     * Get current url
     *
     * @return page url
     */
    public String getCurrentUrl() {
        return selenium.getURL();
    }

}
