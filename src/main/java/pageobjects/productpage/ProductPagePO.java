package pageobjects.productpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class ProductPagePO extends BasePO {
    public ProductPagePO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@id='tbodyid']/child::h2")
    private WebElement pageTitle;

    /**
     * Get page title
     *
     * @return page title text
     */
    public String getPageTitle() {
        return selenium.getText(pageTitle);
    }

    /**
     * Click on add to cart button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnAddToCartButton() throws InterruptedException {
        selenium.clickOn(addToCartButton);
    }

}
