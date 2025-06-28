package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By signinButton = By.id("signin");
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-btn");
    private By usernameButton = By.cssSelector(".username");
    private By errorMessage = By.cssSelector(".api-error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://kolkata.bugbash.live/signin");
    }

    public void openLoginForm() {
        driver.findElement(signinButton).click();  // If needed
    }

    public void selectUsername(String username) {
        WebElement usernameInput = driver.findElement(usernameField);
        usernameInput.click();
       // usernameInput.clear();
      //  usernameInput.sendKeys(username);

		By userName = getElementByText(username);
		WebElement userNameOption = driver.findElement(userName);
		userNameOption.click();

       // usernameInput.sendKeys(org.openqa.selenium.Keys.ENTER);
    }

    public void selectPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.click();
       // passwordInput.clear();
        //passwordInput.sendKeys(password);
       // passwordInput.sendKeys(org.openqa.selenium.Keys.ENTER);
        By userPassword = getElementByText(password);
		WebElement userPasswordOption = driver.findElement(userPassword);
		userPasswordOption.click();
    }

    public void submitLogin() {
        driver.findElement(loginButton).click();
    }

    public WebElement getUserNameButton() {
        return driver.findElement(usernameButton);
    }

    public WebElement getErrorMessage() {
        return driver.findElement(errorMessage);
    }
    
    public By getElementByText(String text) {
        return By.xpath("//*[text()='" + text + "']");
    }

}
