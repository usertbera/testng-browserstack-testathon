package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FavouritesPage {
    private WebDriver driver;

    // Locators
    private By favouriteItems = By.cssSelector(".main .shelf-item");
    private By favouriteTitles = By.cssSelector(".main .shelf-item__title");
    private By removeFavouriteButtons = By.cssSelector(".main .shelf-item button[title='delete']");

    public FavouritesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://kolkata.bugbash.live/favourites");
    }

    public List<WebElement> getFavouriteItems() {
        return driver.findElements(favouriteItems);
    }

    public List<WebElement> getFavouriteTitles() {
        return driver.findElements(favouriteTitles);
    }

    public void removeFavouriteByIndex(int index) {
        List<WebElement> buttons = driver.findElements(removeFavouriteButtons);
        if (index < buttons.size()) {
            buttons.get(index).click();
        }
    }
} 