package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OffersPage {
    private WebDriver driver;

    // Locators
    private By offerItems = By.cssSelector(".offer-item");
    private By offerTitles = By.cssSelector(".offer-item .offer-title");

    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://kolkata.bugbash.live/offers");
    }

    public List<WebElement> getOfferItems() {
        return driver.findElements(offerItems);
    }

    public List<WebElement> getOfferTitles() {
        return driver.findElements(offerTitles);
    }
} 