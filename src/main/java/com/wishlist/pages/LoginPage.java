package com.wishlist.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //@FindBy(id = "email")
    @FindBy(xpath = "//input[@type='email']")
    WebElement useremail;
    //@FindBy(id = "password")
    @FindBy(xpath = "//input[@type='password']")
    WebElement userpassword;
    @FindBy(css = ".save-button")
    WebElement logInButton;

    public LoginPage enterPersonalData(String email, String password) {
        scrollToUpWithJS();
        pause(2000);
        type(useremail, email);
        type(userpassword, password);
        clickWithJS(logInButton, 0, 50);
        //safeType(useremail,email);
        //safeType(userpassword, password);
        return new LoginPage(driver);
    }

    @FindBy(css = ".home-button")
    WebElement buttonHome;

    public LoginPage clickOnHomeLink() {
        click(buttonHome);
        return new LoginPage(driver);
    }

    @FindBy(css = ".error-message")
    WebElement error;

    public LoginPage verifyErrorMessage(String text) {
        Assert.assertTrue(error.getText().contains(text));
        return this;
    }

    @FindBy(css = "[href='/signup']")
    WebElement signUpLink;

    public LoginPage clickOnSignUpLink() {
        clickWithJS(signUpLink, 0, 100);
        return new LoginPage(driver);
    }

    public void scrollToUpWithJS() {
        js.executeScript("window.scrollTo(0, 0)");
    }

    @FindBy(css = ".auth-container")
    WebElement loginContainer;

    public LoginPage verifyLoginForm(String text) {
        Assert.assertTrue(loginContainer.getText().contains(text));
        return this;
    }
}