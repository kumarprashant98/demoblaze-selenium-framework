package pageobjects.cartpage;

import dataobjects.OrderDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class CartPagePO extends BasePO {
    public CartPagePO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//tr[@class='success']/child::td[2]")
    private WebElement ProductTitle;

    @FindBy(id = "orderModalLabel")
    private WebElement placeOrderTitle;

    @FindBy(id = "name")
    private WebElement nameTextBox;

    @FindBy(id = "country")
    private WebElement countryTextBox;

    @FindBy(id = "city")
    private WebElement cityTextBox;

    @FindBy(id = "card")
    private WebElement cardTextBox;

    @FindBy(id = "month")
    private WebElement monthTextBox;

    @FindBy(id = "year")
    private WebElement yearTextBox;

    @FindBy(id = "totalp")
    private WebElement productsTotalPrice;

    @FindBy(id = "totalm")
    private WebElement placeOrderAmount;

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchaseButton;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    private WebElement successMessage;

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement okButton;

    /**
     * Get product title
     *
     * @return product title text
     */
    public String getProductTitle() {
        return selenium.getText(ProductTitle);
    }

    /**
     * Is place order displayed
     *
     * @return true or false
     */
    public boolean placeOrderDisplayed() {
        return selenium.isElementPresent(placeOrderTitle);
    }

    /**
     * Enter data in place order fields
     *
     * @param orderdata details
     */
    public void enterPlaceOrderData(OrderDetails orderdata) {
        selenium.enterText(nameTextBox, orderdata.getName(), true);
        selenium.enterText(countryTextBox, orderdata.getCountry(), true);
        selenium.enterText(cityTextBox, orderdata.getCity(), true);
        selenium.enterText(cardTextBox, orderdata.getCreditcard(), true);
        selenium.enterText(monthTextBox, orderdata.getMonth(), true);
        selenium.enterText(yearTextBox, orderdata.getYear(), true);
    }

    /**
     * Click on place order button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnPlaceOrderButton() throws InterruptedException {
        selenium.clickOn(placeOrderButton);
    }

    /**
     * Click on purchase button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnPurchaseButton() throws InterruptedException {
        selenium.clickOn(purchaseButton);
    }

    /**
     * Get checkout success message
     *
     * @return success message text
     */
    public String getCheckOutSuccessMessage() {
        return selenium.getText(successMessage);
    }

    /**
     * Click on ok button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnOkButton() throws InterruptedException {
        selenium.clickOn(okButton);
    }

    /**
     * Get products Total price
     *
     * @return total price
     */
    public String getProductsTotalPrice() {
        return selenium.getText(productsTotalPrice);
    }

    /**
     * Get place order total amount
     *
     * @return order total amount
     */
    public String getPlaceOrderTotalAmount() {
        String totalAmount = selenium.getText(placeOrderAmount);
        return totalAmount.replace("Total: ", "");
    }
}
