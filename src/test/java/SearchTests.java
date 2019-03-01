import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    @Test
    public void basicSearchTest() {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        HomePage homePage = landingPage.login("linkedin.tst.yanina@gmail.com", "Test123!");
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");
    }
}
