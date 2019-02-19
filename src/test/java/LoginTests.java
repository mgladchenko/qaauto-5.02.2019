import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "/Users/mykola/projects/qaauto-5.02.2019/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void successfulLoginTest() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("linkedin.tst.yanina@gmail.com", "Test123!");

        WebElement profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));

        Assert.assertTrue(profileMenuItem.isDisplayed(), "profileMenuItem is not displayed on Home page.");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/",
                "Home page URL is incorrect.");
        //logout
    }

    @Test
    public void negativeLoginTest() {
        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        userEmailField.sendKeys("linkedin.tst.yanina@gmail.com");
        userPasswordField.sendKeys("12345");
        signInButton.click();

        WebElement passwordErrorMessageBlock = driver.findElement(By.xpath("//div[@id='error-for-password']"));

        Assert.assertTrue(passwordErrorMessageBlock.isDisplayed(),
                "passwordErrorMessageBlock is not displayed on Home page.");

        Assert.assertEquals(passwordErrorMessageBlock.getText(),
                "Hmm, that's not the right password. Please try again or request a new one.",
                "Wrong validation message text for 'password' field.");
    }
}
