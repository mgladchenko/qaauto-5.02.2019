import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public void successfulLoginTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/mykola/projects/qaauto-5.02.2019/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

    }
}
