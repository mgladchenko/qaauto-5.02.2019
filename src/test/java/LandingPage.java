import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    WebDriver driver;

    WebElement userEmailField;
    WebElement userPasswordField;
    WebElement signInButton;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    public void initElements() {
        userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
    }

    public void login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
    }


}
