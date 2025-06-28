// src/main/java/pages/MainPage.java
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private WebDriver driver;

    // Locators
    private By searchInput = By.cssSelector("input[placeholder='Search']");
    private By productItems = By.cssSelector(".shelf-item");
    public By productsFoundLabel = By.cssSelector(".products-found");
    private By allProductTitles = By.cssSelector(".shelf-item .shelf-item__title");
    private By sortDropdown = By.cssSelector("div.sort select");
    private By productPrices = By.cssSelector(".shelf-item__price");

    private By favButtons = By.cssSelector("span.MuiIconButton-label svg");
    private By favItems = By.cssSelector(".shelf-item");
    private By favouritesTab = By.cssSelector("a#favourites strong");

    private By cartCount = By.id("cart-count");
    private By productTitles = By.cssSelector(".shelf-item__title");
    private By addToCartButtons = By.cssSelector(".shelf-item__buy-btn");
    private By cartItems = By.cssSelector(".float-cart .shelf-item");
    private By cartProductTitle = By.cssSelector(".float-cart .shelf-item__details .title");
    private By cartPriceTotal = By.cssSelector(".sub-price__val");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://kolkata.bugbash.live/");
    }

    public void searchFor(String term) {
        WebElement input = driver.findElement(searchInput);
        input.clear();
        input.sendKeys(term + Keys.ENTER);
    }

    public List<WebElement> getMatchingProductsByText(String regex) {
        List<WebElement> matches = new ArrayList<>();
        for (WebElement el : driver.findElements(productItems)) {
            if (el.getText().matches("(?s).*" + regex + ".*")) {
                matches.add(el);
            }
        }
        return matches;
    }

    public int getProductCount() {
        return driver.findElements(productItems).size();
    }

    public void toggleBrand(String brand) {
        driver.findElement(By.xpath("//*[text()='" + brand + "']")).click();
    }

    public List<String> getVisibleProductTitles() {
        List<String> titles = new ArrayList<>();
        for (WebElement title : driver.findElements(allProductTitles)) {
            if (title.isDisplayed()) {
                titles.add(title.getText());
            }
        }
        return titles;
    }

    public void selectSortOption(String value) {
        WebElement dropdown = driver.findElement(sortDropdown);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public List<String> getSortOptions() {
        List<String> options = new ArrayList<>();
        Select select = new Select(driver.findElement(sortDropdown));
        for (WebElement option : select.getOptions()) {
            String val = option.getAttribute("value");
            if (!val.isEmpty()) {
                options.add(val);
            }
        }
        return options;
    }

    public List<Double> getVisibleProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement priceEl : driver.findElements(productPrices)) {
            if (priceEl.isDisplayed()) {
                String text = priceEl.getText().replaceAll("[^\\d.]", "");
                if (!text.isEmpty()) {
                    prices.add(Double.parseDouble(text));
                }
            }
        }
        return prices;
    }

    public void addFirstProductToFavourites() {
        driver.findElements(favButtons).get(0).click();
    }

    public void goToFavourites() {
        driver.findElement(favouritesTab).click();
        driver.get("https://bstackdemo.com/favourites");
    }

    public void removeFavouriteByIndex(int index) {
        List<WebElement> items = driver.findElements(favItems);
        if (index < items.size()) {
            WebElement removeBtn = items.get(index).findElement(By.cssSelector(".MuiSvgIcon-root.Icon"));
            removeBtn.click();
        }
    }

    public String addProductToCart(int index) {
        List<WebElement> titles = driver.findElements(productTitles);
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        if (index < titles.size() && index < buttons.size()) {
            String title = titles.get(index).getText();
            buttons.get(index).click();
            return title;
        }
        return null;
    }

    public OrdersPage goToOrders() {
        driver.findElement(By.id("orders")).click();
        return new OrdersPage(driver);
    }
}
