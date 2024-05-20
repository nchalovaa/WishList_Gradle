package com.wishlist.pages;

import io.opentelemetry.api.baggage.propagation.W3CBaggagePropagator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = "[href='/about']")
    WebElement aboutUsLink;

    public HomePage clickOnAboutUsLink() {
        click(aboutUsLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//span['О нас']")
    WebElement result;

    public HomePage verifyAboutUs(String text) {
        Assert.assertTrue(result.getText().contains(text));
        return this;
    }

    @FindBy(css = "[href='/login']")
    WebElement logInLink;

    public HomePage clickOnLogInLink() {
        click(logInLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//button[.='Log In']")
    WebElement logInresult;

    public HomePage verifyLogInButton(String text) {
        Assert.assertTrue(logInresult.getText().contains(text));
        return this;
    }

    @FindBy(css = "[href='/signUp']")
    WebElement signUp;

    public HomePage clickOnSignUpLink() {
        click(signUp);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//button[.='Sign Up']")
    WebElement signUpresult;

    public HomePage verifySignUpButton(String text) {
        Assert.assertTrue(signUpresult.getText().contains(text));
        return this;
    }

    @FindBy(css = ".create_list_button")
    WebElement saveWishList;

    public HomePage clickOnButtonCreateNewWishList() {
        clickWithJS(saveWishList, 0, 300);
        return new HomePage(driver);
    }

    @FindBy(css = ".save-button-custom")
    WebElement save;

    public HomePage verifySaveButton(String text) {
        Assert.assertTrue(save.getText().contains(text));
        return this;
    }

    @FindBy(css = "[href='/createWishlist']")
    WebElement iWantbutton;

    public HomePage clickIwantWishListButton() {
        clickWithJS(iWantbutton, 0, 700);
        return new HomePage(driver);
    }
}
