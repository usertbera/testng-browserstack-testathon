package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    private WebDriver driver;

    // Locators
    private By firstNameField = By.cssSelector("input[placeholder='First Name'], input[aria-label='First Name']");
    private By lastNameField = By.cssSelector("input[placeholder='Last Name'], input[aria-label='Last Name']");
    private By addressField = By.cssSelector("input[placeholder='Address'], input[aria-label='Address']");
    private By stateField = By.cssSelector("input[placeholder='State/Province'], input[aria-label='State/Province']");
    private By postalCodeField = By.cssSelector("input[placeholder='Postal Code'], input[aria-label='Postal Code']");
    private By submitButton = By.cssSelector("button[type='submit'], button[cursor='pointer']");

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