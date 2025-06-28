package com.browserstack;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FavouritesPage;
import pages.MainPage;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BStackFavouritesTest extends SeleniumTest {

    @Test
    public void testAddToFavouritesAndVerify() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        MainPage mainPage = new MainPage(driver);
        mainPage.goTo();

        // Add first product to favourites
        String productName = mainPage.addProductToCart(0); // Use addProductToFavourites if available
        mainPage.addFirstProductToFavourites();

        FavouritesPage favouritesPage = new FavouritesPage(driver);
        wait.until(driver1 -> favouritesPage.getFavouriteTitles().size() > 0);
        List<String> favTitles = favouritesPage.getFavouriteTitles().stream().map(e -> e.getText()).collect(Collectors.toList());
        Assert.assertTrue(favTitles.contains(productName), "Favourites should contain the product: " + productName);
    }

    @Test(dependsOnMethods = "testAddToFavouritesAndVerify")
    public void testRemoveFromFavouritesAndVerify() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        FavouritesPage favouritesPage = new FavouritesPage(driver);
        favouritesPage.goTo();
        wait.until(driver1 -> favouritesPage.getFavouriteTitles().size() > 0);
        String productName = favouritesPage.getFavouriteTitles().get(0).getText();
        favouritesPage.removeFavouriteByIndex(0);
        wait.until(driver1 -> favouritesPage.getFavouriteTitles().stream().noneMatch(e -> e.getText().equals(productName)));
        List<String> favTitles = favouritesPage.getFavouriteTitles().stream().map(e -> e.getText()).collect(Collectors.toList());
        Assert.assertFalse(favTitles.contains(productName), "Favourites should not contain the product after removal: " + productName);
    }
}