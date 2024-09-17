package pageobjects.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;


public class LoginPO extends BasePO {
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "loginusername")
    private WebElement usernameTextBox;

    @FindBy(id = "loginpassword")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    @FindBy(xpath = "//h5[@id='logInModalLabel']")
    private WebElement headerText;

    /**
     * Enter the valid login data and click on login button
     *
     * @param username and password data
     * @throws InterruptedException Exception
     */
    public void enterLoginData(String username,String password) throws InterruptedException {
        selenium.enterText(usernameTextBox, username, true);
        selenium.enterText(passwordTextBox, password, true);
        selenium.clickOn(loginButton);
    }

    /**
     * Get login header text
     *
     * @return header text
     */
    public String getLoginHeaderText() {
        return selenium.getText(headerText);
    }


}