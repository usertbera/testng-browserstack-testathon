package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;

import java.time.Duration;
import java.util.*;

public class BStackBrandFilterTest extends SeleniumTest {

    private static final Map<String, List<String>> BRAND_DEVICE_MAP = new HashMap<String, List<String>>() {{
        put("Apple", Arrays.asList("iPhone 12", "iPhone 12 Mini", "iPhone 12 Pro Max", "iPhone 12 Pro", "iPhone 11", "iPhone 11 Pro", "iPhone XS", "iPhone XR", "iPhone XS Max"));
        put("Samsung", Arrays.asList("Galaxy S20", "Galaxy S20+", "Galaxy S20 Ultra", "Galaxy S10", "Galaxy S9", "Galaxy Note 20", "Galaxy Note 20 Ultra"));
        put("Google", Arrays.asList("Pixel 4", "Pixel 3", "Pixel 2"));
        put("OnePlus", Arrays.asList("One Plus 8", "One Plus 8T", "One Plus 8 Pro", "One Plus 7T", "One Plus 7", "One Plus 6T"));
    }};

    @DataProvider(name = "brands")
    public Object[][] brands() {
        return BRAND_DEVICE_MAP.keySet().stream().map(b -> new Object[]{b}).toArray(Object[][]::new);
    }

    @Test(dataProvider = "brands")
    public void testFilterByBrand(String brand) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        MainPage mainPage = new MainPage(driver);
        mainPage.goTo();

        // Toggle the brand filter
        mainPage.toggleBrand(brand);

        // Wait for the product list to update
        wait.until(driver1 -> mainPage.getVisibleProductTitles().size() > 0);
        List<String> productTitles = mainPage.getVisibleProductTitles();
        List<String> expectedDevices = BRAND_DEVICE_MAP.get(brand);

        // Assert all product titles are in the expected device list for the brand
        for (String title : productTitles) {
            Assert.assertTrue(expectedDevices.contains(title),
                    "Product title '" + title + "' is not a valid device for brand '" + brand + "'");
        }
    }
} 