package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OrdersPage {
    private WebDriver driver;

    // Locators
    private By orderItems = By.cssSelector(".order-item, .main [class*='order']");
    private By orderTitles = By.cssSelector(".order-item .title, .main [class*='order'] strong");
    private By orderDates = By.cssSelector(".order-item .date, .main [class*='order'] [class*='date']");

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://kolkata.bugbash.live/orders");
    }

    public List<WebElement> getOrderItems() {
        return driver.findElements(orderItems);
    }

    public List<WebElement> getOrderTitles() {
        return driver.findElements(orderTitles);
    }

    public List<WebElement> getOrderDates() {
        return driver.findElements(orderDates);
    }
} 