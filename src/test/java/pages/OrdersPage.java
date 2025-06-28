package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OrdersPage {
    private WebDriver driver;

    // Locators
    private By orderGroups = By.cssSelector(".order");
    private By orderPlacedLabels = By.cssSelector(".order-info .label");
    private By orderPlacedValues = By.cssSelector(".order-info .value");
    private By orderTitles = By.cssSelector(".a-fixed-left-grid-col.a-col-right .a-row");
    private By orderDescriptions = By.cssSelector(".a-fixed-left-grid-col.a-col-right .a-row:nth-child(2)");
    private By orderPrices = By.cssSelector(".a-fixed-left-grid-col.a-col-right .a-row .a-size-small.a-color-price");

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://kolkata.bugbash.live/orders");
    }

    public List<WebElement> getOrderGroups() {
        return driver.findElements(orderGroups);
    }

    public List<WebElement> getOrderPlacedLabels() {
        return driver.findElements(orderPlacedLabels);
    }

    public List<WebElement> getOrderPlacedValues() {
        return driver.findElements(orderPlacedValues);
    }

    public List<WebElement> getOrderTitles() {
        return driver.findElements(orderTitles);
    }

    public List<WebElement> getOrderDescriptions() {
        return driver.findElements(orderDescriptions);
    }

    public List<WebElement> getOrderPrices() {
        return driver.findElements(orderPrices);
    }
} 