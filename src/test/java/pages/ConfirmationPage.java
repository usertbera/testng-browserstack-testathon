package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationPage {
    private WebDriver driver;

    // Locators
    private By confirmationMessage = By.xpath("//*[contains(text(),'Your Order has been successfully placed')]");
    private By orderNumber = By.xpath("//*[contains(text(),'order number')]/strong");
    private By downloadReceipt = By.xpath("//*[contains(text(),'Download order receipt')]");
    private By continueShopping = By.xpath("//*[contains(text(),'Continue Shopping')]");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }

    public String getOrderNumber() {
        return driver.findElement(orderNumber).getText();
    }

    public void downloadReceipt() {
        driver.findElement(downloadReceipt).click();
    }

    public void continueShopping() {
        driver.findElement(continueShopping).click();
    }
} 