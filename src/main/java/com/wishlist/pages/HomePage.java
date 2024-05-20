package com.wishlist.pages;

import org.openqa.selenium.By;
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

    @FindBy(css = "ul.nav-list :nth-child(3)")
    WebElement logInLink;

    public HomePage clickOnLogInLink() {
        click(logInLink);
        return new HomePage(driver);
    }

    @FindBy(css = "ul.nav-list :nth-child(3)")
    WebElement linkLogin;

    public boolean logInLinkPresent() {
        linkLogin.isDisplayed();
        return true;
    }


    @FindBy(xpath = "//button[.='Log In']")
    WebElement logInresult;

    public HomePage verifyLogInButton(String text) {
        Assert.assertTrue(logInresult.getText().contains(text));
        return this;
    }

    @FindBy(css = "ul.nav-list :nth-child(4)")
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
        clickWithJS(saveWishList, 0, 500);
        return new HomePage(driver);
    }

    @FindBy(css = ".save-button-custom")
    WebElement save;

    public HomePage verifySaveButton(String text) {
        Assert.assertTrue(save.getText().contains(text));
        return this;
    }

    @FindBy(xpath = "//button[text()='I want a Wishlist']")
    WebElement iWantbutton;

    public HomePage clickIwantWishListButtonWithJS() {
        clickWithJS(iWantbutton, 0, 900);
        return new HomePage(driver);
    }

    @FindBy(css = "[href='/privacy-policy']")
    WebElement privacyPolicyLink;

    public HomePage clickOnPrivacyPolicyLink() {
        clickWithJS(privacyPolicyLink, 0, 500);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//span[.='PrivacyPolicy']")
    WebElement textPolicy;

    public HomePage verifyPrivacyPolicy(String text) {
        Assert.assertTrue(textPolicy.getText().contains(text));
        return this;
    }

    @FindBy(css = "li:nth-child(3)")
    WebElement logOutLink;

    public HomePage clickOnLogOutLink() {
        return this;
    }

    @FindBy(css = ".pink-box")
    WebElement pinkBox;

    public HomePage verifyPinkBox(String text) {
        Assert.assertTrue(pinkBox.getText().contains(text));
        return this;
    }

    @FindBy(css = ".header")
    WebElement image;
    public boolean isHeaderImagePresent() {
        return isElementPresent(image);
    }

    //    @FindBy(xpath = "//button[.='I want a Wishlist']")
//    WebElement iWantWLbutton;
//    public HomePage isIWantWLButtonPresent(String text) {
//        Assert.assertTrue(iWantWLbutton.getText().contains(text));
//        return this;
//    }
    @FindBy(css = ".section")
    WebElement homePagesection;
    public boolean isHomePagePresent() {
        return isElementPresent(homePagesection);
    }

    @FindBy(css="svg")
    WebElement svgAccount;
    public HomePage clickOnIconAccount() {
        click(svgAccount);
        return new HomePage(driver);
    }


}