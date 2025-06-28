package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;
import java.util.List;

public class BStackOrderFlowTest extends SeleniumTest {
    @Test
    public void testAddToCartCheckoutAndVerifyOrder() {
        // Test data and selectors
        String username = "demouser";
        String password = "testingisfun99";
        int productIndex = 0;
        String firstName = "Test";
        String lastName = "User";
        String address = "123 Test St";
        String state = "TestState";
        String postalCode = "12345";
        By userNameButtonSelector = By.cssSelector(".username");
        By cartItemSelector = By.cssSelector(".float-cart .shelf-item");
        By firstNameInputSelector = By.cssSelector("#firstNameInput");
        By confirmationMsgSelector = By.xpath("//*[contains(text(),'Your Order has been successfully placed')]");
        By productListSelector = By.cssSelector(".shelf-item");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.selectUsername(username);
        loginPage.selectPassword(password);
        loginPage.submitLogin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameButtonSelector));
        Assert.assertTrue(loginPage.getUserNameButton().isDisplayed(), "User should be logged in");

        // Add first product to cart
        MainPage mainPage = new MainPage(driver);
        String productName = mainPage.addProductToCart(productIndex);
        Assert.assertNotNull(productName, "Product should be added to cart");
        // Wait for cart to update (e.g., cart count or cart item visible)
        CartPage cartPage = new CartPage(driver);
        wait.until(driver1 -> cartPage.getCartItems().size() > 0);
        Assert.assertTrue(cartPage.getCartItems().size() > 0, "Cart should have at least one item");
        cartPage.clickCheckout();

        // Wait for checkout page (wait for first name field)
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInputSelector));
        checkoutPage.fillShippingAddress(firstName, lastName, address, state, postalCode);
        checkoutPage.submit();

        // Wait for confirmation page (wait for confirmation message)
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMsgSelector));
        Assert.assertTrue(confirmationPage.getConfirmationMessage().contains("successfully placed"), "Order should be placed");
        String orderNumber = confirmationPage.getOrderNumber();
        Assert.assertNotNull(orderNumber, "Order number should be present");
        confirmationPage.continueShopping();

        // Wait for main page to load (wait for product list)
        wait.until(ExpectedConditions.visibilityOfElementLocated(productListSelector));

        // Go to Orders and verify
        MainPage mainPageAfterOrder = new MainPage(driver);
        OrdersPage ordersPage = mainPageAfterOrder.goToOrders();
        wait.until(driver1 -> ordersPage.getOrderTitles().size() > 0);
        List<org.openqa.selenium.WebElement> orderTitles = ordersPage.getOrderTitles();
        boolean found = orderTitles.stream().anyMatch(e -> e.getText().contains(productName));
        Assert.assertTrue(found, "Order should contain the product: " + productName);
    }
} 