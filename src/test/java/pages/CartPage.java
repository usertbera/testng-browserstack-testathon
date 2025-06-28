package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {
    private WebDriver driver;

    // Locators
    private By cartItems = By.cssSelector(".float-cart .shelf-item");
    private By cartProductTitles = By.cssSelector(".float-cart .shelf-item__details .title");
    private By cartSubtotal = By.cssSelector(".float-cart .sub-price__val, .float-cart .subtotal");
    private By checkoutButton = By.cssSelector(".buy-btn");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCartItems() {
        return driver.findElements(cartItems);
    }

    public List<WebElement> getCartProductTitles() {
        return driver.findElements(cartProductTitles);
    }

    public String getCartSubtotal() {
        return driver.findElement(cartSubtotal).getText();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
} 