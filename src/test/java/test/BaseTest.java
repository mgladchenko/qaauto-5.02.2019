package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LandingPage;

public class BaseTest {
    private WebDriver driver;
    LandingPage landingPage;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "/Users/mykola/projects/qaauto-5.02.2019/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        landingPage = new LandingPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
