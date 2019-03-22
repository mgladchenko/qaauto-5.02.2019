package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginSubmitPage;

public class LoginTests extends BaseTest {

    @DataProvider
    public Object[][] validData() {
        return new Object[][]{
                { "linkedin.tst.yanina@gmail.com", "Test123!"},
                { "linkedin.TST.yanina@gmail.com", "Test123!"},
                { " linkedin.tst.yanina@gmail.com ", "Test123!"}
        };
    }

    @Test(dataProvider = "validData")
    public void successfulLoginTest(String userEmail, String userPassword) {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        HomePage homePage = landingPage.login(userEmail, userPassword, HomePage.class);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");
    }

    @DataProvider
    public Object[][] invalidData() {
        return new Object[][]{
                { "linkedin.tst.yanina@gmail.com", "12345", "", "Hmm, that's not the right password. Please try again or request a new one."}
        };
    }

    @Test(dataProvider = "invalidData")
    public void negativeLoginTest(String userEmail,
                                  String userPassword,
                                  String emailValidationMessage,
                                  String passwordValidationMessage)
    {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        LoginSubmitPage loginSubmitPage = landingPage.login(userEmail, userPassword);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "LoginSubmit page is not loaded.");

        Assert.assertEquals(loginSubmitPage.getUserEmailValidationText(), emailValidationMessage,
                "userEmail validation message text is wrong.");
        Assert.assertEquals(loginSubmitPage.getUserPasswordValidationText(), passwordValidationMessage,
                "userPassword validation message text is wrong.");
    }
}
