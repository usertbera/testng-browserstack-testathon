package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    // Locators
    private By firstNameField = By.id("firstNameInput");
    private By lastNameField = By.id("lastNameInput");
    private By addressField = By.id("addressLine1Input");
    private By stateField = By.id("provinceInput");
    private By postalCodeField = By.id("postCodeInput");
    private By submitButton = By.id("checkout-shipping-continue");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillShippingAddress(String firstName, String lastName, String address, String state, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void submit() {
        driver.findElement(submitButton).click();
    }
} 