import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage {
    private WebDriver driver;
    private WebElement loginForm;
    private WebElement userEmailValidationMessage;
    private WebElement userPasswordValidationMessage;

    public LoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        loginForm = driver.findElement(By.xpath("//form[@class='login__form']"));
        userEmailValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        userPasswordValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
    }

    public boolean isPageLoaded() {
        return loginForm.isDisplayed()
                && driver.getCurrentUrl().contains("/login-submit")
                && driver.getTitle().contains("Sign In to LinkedIn");
    }

    public String getUserEmailValidationText() {
        return userEmailValidationMessage.getText();
    }

    public String getUserPasswordValidationText() {
        return userPasswordValidationMessage.getText();
    }
}
