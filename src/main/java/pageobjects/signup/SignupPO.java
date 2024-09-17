package pageobjects.signup;

import dataobjects.UserDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class SignupPO extends BasePO {
    public SignupPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sign-username")
    private WebElement usernameTextBox;

    @FindBy(id = "sign-password")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement signupButton;

    @FindBy(xpath = "//h5[text()='Sign up']")
    private WebElement signUpHeaderText;

    /**
     * Enter valid signup data and click on signup button
     *
     * @param signupData data
     * @throws InterruptedException Exception
     */
    public void enterSignupData(UserDetails signupData) throws InterruptedException {
        selenium.enterText(usernameTextBox, signupData.getUsername(), true);
        selenium.enterText(passwordTextBox, signupData.getPassword(), true);
        selenium.clickOn(signupButton);
    }

    /**
     * Get sign up header text
     *
     * @return header text
     */
    public String getSignUpHeaderText() {
        return selenium.getText(signUpHeaderText);
    }
}
