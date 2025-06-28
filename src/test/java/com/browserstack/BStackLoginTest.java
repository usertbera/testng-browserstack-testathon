package com.browserstack;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//package com.browserstack;

import org.testng.annotations.Test;
import pages.LoginPage;

public class BStackLoginTest extends SeleniumTest {

    @Test
    public void validLoginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
       // loginPage.openLoginForm();
        loginPage.selectUsername("demouser");
        loginPage.selectPassword("testingisfun99");
        loginPage.submitLogin();
        

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(loginPage.getLogoutButton()));
        Thread.sleep(2000);

        

        Assert.assertTrue(
            loginPage.getUserNameButton().isDisplayed(),
            "Logout button should be visible after valid login."
        );
    }

  /*  @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
      //  loginPage.openLoginForm();
        loginPage.selectUsername("invaliduser");
        loginPage.submitLogin();

        Assert.assertTrue(
            loginPage.getErrorMessage().isDisplayed(),
            "Error message should be visible after invalid login."
        );
    }*/
}
