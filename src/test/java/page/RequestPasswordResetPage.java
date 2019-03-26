package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestPasswordResetPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    private WebElement findAccountButton;

    public RequestPasswordResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded() {
        return findAccountButton.isDisplayed()
                && driver.getCurrentUrl().contains("uas/request-password-reset")
                && driver.getTitle().equals("Reset Password | LinkedIn");
    }

    public RequestPasswordResetSubmitPage findAccount(String userEmail) {
        userEmailField.sendKeys(userEmail);

        return new RequestPasswordResetSubmitPage(driver);
    }
}
