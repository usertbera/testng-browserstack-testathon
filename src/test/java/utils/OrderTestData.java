package utils;

import org.openqa.selenium.By;

public class OrderTestData {
    public static final int PRODUCT_INDEX = 0;
    public static final String FIRST_NAME = "Test";
    public static final String LAST_NAME = "User";
    public static final String ADDRESS = "123 Test St";
    public static final String STATE = "TestState";
    public static final String POSTAL_CODE = "12345";

    public static final By USERNAME_BUTTON_SELECTOR = By.cssSelector(".username");
    public static final By CART_ITEM_SELECTOR = By.cssSelector(".float-cart .shelf-item");
    public static final By FIRST_NAME_INPUT_SELECTOR = By.cssSelector("#firstNameInput");
    public static final By CONFIRMATION_MSG_SELECTOR = By.xpath("//*[contains(text(),'Your Order has been successfully placed')]");
    public static final By PRODUCT_LIST_SELECTOR = By.cssSelector(".shelf-item");
} 