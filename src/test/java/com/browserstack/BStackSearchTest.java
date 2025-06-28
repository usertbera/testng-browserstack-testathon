package com.browserstack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

public class BStackSearchTest extends SeleniumTest {

    @Test
    public void homepageLoadsWithVisibleProductList() {
        MainPage main = new MainPage(driver);
        main.goTo();

        int productCount = main.getProductCount();
        Assert.assertTrue(productCount > 0, "Product list should be visible on homepage");

        Assert.assertTrue(driver.findElement(main.productsFoundLabel).isDisplayed(),
                "Products found label should be visible");
    }

    @Test
    public void searchShowsExpectedResultsForKnownKeyword() {
        MainPage main = new MainPage(driver);
        main.goTo();

        main.searchFor("iPhone");

        List<String> matchingTitles = main.getVisibleProductTitles();
        boolean found = matchingTitles.stream().anyMatch(title -> title.toLowerCase().contains("iphone"));

        Assert.assertTrue(found, "Search should return products containing 'iPhone'");
    }

    @Test
    public void searchIsCaseInsensitive() {
        MainPage main = new MainPage(driver);
        main.goTo();

        main.searchFor("IPHONE");

        List<String> matchingTitles = main.getVisibleProductTitles();
        boolean found = matchingTitles.stream().anyMatch(title -> title.toLowerCase().contains("iphone"));

        Assert.assertTrue(found, "Search should be case-insensitive");
    }

    @Test
    public void searchSupportsPartialTextMatching() {
        MainPage main = new MainPage(driver);
        main.goTo();

        main.searchFor("ipho");

        List<String> matchingTitles = main.getVisibleProductTitles();
        boolean found = matchingTitles.stream().anyMatch(title -> title.toLowerCase().contains("iphone"));

        Assert.assertTrue(found, "Partial search should return matching results");
    }

    @Test
    public void searchWithNoResultsShowsEmptyView() {
        MainPage main = new MainPage(driver);
        main.goTo();

        main.searchFor("xyznotfound");

        int count = main.getProductCount();
        Assert.assertEquals(count, 0, "Search with no results should show 0 products");

        // Optional: assert a "no results" message
        // Assert.assertTrue(driver.getPageSource().contains("No products found"));
    }

    @Test
    public void emptySearchResetsFullProductList() {
        MainPage main = new MainPage(driver);
        main.goTo();

        int initialCount = main.getProductCount();

        main.searchFor("iPhone"); // narrow
        main.searchFor("");       // reset to full list

        int resetCount = main.getProductCount();
        Assert.assertEquals(resetCount, initialCount, "Empty search should reset product list");
    }

    @Test
    public void whitespaceOnlySearchDoesNotBreakDisplay() {
        MainPage main = new MainPage(driver);
        main.goTo();

        main.searchFor("  ");

        int count = main.getProductCount();
        Assert.assertTrue(count > 0, "Whitespace search should still show products");
    }

    @Test
    public void multipleSequentialSearchesWorkCorrectly() {
        MainPage main = new MainPage(driver);
        main.goTo();

        main.searchFor("iPhone");
        List<String> firstSearch = main.getVisibleProductTitles();
        boolean foundFirst = firstSearch.stream().anyMatch(title -> title.toLowerCase().contains("iphone"));
        Assert.assertTrue(foundFirst, "First search should return iPhones");

        main.searchFor("Samsung");
        List<String> secondSearch = main.getVisibleProductTitles();
        boolean foundSecond = secondSearch.stream().anyMatch(title -> title.toLowerCase().contains("samsung"));
        Assert.assertTrue(foundSecond, "Second search should return Samsungs");
    }
}
