package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

public class SearchTests extends BaseTest {

    @Test
    public void basicSearchTest() {
        String searchTerm = "HR";

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        HomePage homePage = landingPage.login("linkedin.tst.yanina@gmail.com", "Test123!");
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");

        SearchPage searchPage = homePage.search(searchTerm);
        Assert.assertTrue(searchPage.isPageLoaded(), "Search page is not loaded.");

        Assert.assertEquals(searchPage.getSearchResultCount(), 10,
                "Search results count is wrong.");

        List<String> searchResultsList = searchPage.getSearchResultsList();

        for(String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "SearchTerm: "+searchTerm+" not found in: \n"+searchResult);
        }







    }
}
