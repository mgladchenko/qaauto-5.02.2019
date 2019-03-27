package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@class='link-forgot-password']")
    private WebElement forgotPasswordLink;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public <T> T login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        if (driver.getCurrentUrl().contains("/feed")) {
            return (T) new HomePage(driver);
        } else {
            return (T) new LoginSubmitPage(driver);
        }
    }

    public <ExpectedPage> ExpectedPage login(String userEmail, String userPassword, Class<ExpectedPage> expectedPage) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return PageFactory.initElements(driver, expectedPage);
    }

    public RequestPasswordResetPage clickOnForgotPasswordLink() {
        forgotPasswordLink.click();
        return new RequestPasswordResetPage(driver);
    }

    public boolean isPageLoaded() {
        return signInButton.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
                && driver.getTitle().equals("LinkedIn: Log In or Sign Up");
    }
}

















