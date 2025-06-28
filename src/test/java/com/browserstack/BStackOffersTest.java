package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OffersPage;

import java.time.Duration;

public class BStackOffersTest extends SeleniumTest {
    @Test
    public void testNoPromotionalOffersMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        OffersPage offersPage = new OffersPage(driver);
        offersPage.goTo();
        By noOffersMsg = By.xpath("//*[contains(text(),'Sorry we do not have any promotional offers in your city.')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(noOffersMsg));
        Assert.assertTrue(driver.findElement(noOffersMsg).isDisplayed(),
                "The no promotional offers message should be visible.");
    }
} 