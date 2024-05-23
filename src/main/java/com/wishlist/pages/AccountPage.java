package com.wishlist.pages;


import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".create-wishlist-button-in-account")
    //@FindBy(xpath = "//a[contains(text(),'Create WishList')]")
    WebElement account;

    public AccountPage verifyAccountPage(String text) {
        Assert.assertTrue(account.getText().contains(text));
        return this;
    }

    // @FindBy(css=".create-wishlist-button")
    @FindBy(xpath = "//a[contains(text(),'Create WishList')]")
    WebElement wishListButtonAccount;

    public AccountPage createWishListButton() {
        click(wishListButtonAccount);
        return new AccountPage(driver);
    }

    @FindBy(css = "ul.nav-list :nth-child(3)")
    WebElement clickOnLogOut;

    public AccountPage clickOnLogoutLinkAccount() {
        click(clickOnLogOut);
        return new AccountPage(driver);
    }

    @FindBy(css = ".delete-button-in-account")
    WebElement clickDeleteButtonToDeleteAccount;
    @FindBy(css = ".delete-account-button")
    WebElement selectDeleteButton;

    public AccountPage selectDeleteAccountButton() {
        safeClick(clickDeleteButtonToDeleteAccount);
        click(selectDeleteButton);
        return new AccountPage(driver);
    }

    @FindBy(css = ".delete-button-in-account")
    WebElement verifyDelete;

    public AccountPage verifyDelete(String text) {
        Assert.assertTrue(verifyDelete.getText().contains(text));
        return this;
    }

    @FindBy(css = ".create-wishlist-button")
    WebElement createWLButton;

    public AccountPage clickOnCreateWishListButton() {
        click(createWLButton);
        return new AccountPage(driver);
    }

    @FindBy(css = ".ant-card")
    WebElement cardExisted;

    public AccountPage verifyCardOfWishList() {
        Assert.assertTrue(isElementPresent(cardExisted));
        return this;
    }

    //    @FindBy(css=".ant-card")
    @FindBy(css = ".ant-card-head")
    WebElement card;

    public AccountPage clickOnWishlist() {
        click(card);
        return new AccountPage(driver);
    }

    //    @FindBy(xpath = "//button [.='add gift']")
    @FindBy(css = ".add-gift-in-card-button-in-account")
    WebElement addGiftButton;

    public AccountPage clickOnAddGiftButton() {
        //click(addGiftbutton);
        clickWithJS(addGiftButton, 0, 500);
        return new AccountPage(driver);
    }


    @FindBy(css = ".gift-count-text-in-account")
    WebElement counterGifts;

    public int getGiftCount() {
        String text = counterGifts.getText().replaceAll("[^0-9]", "");
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
//    @FindBy(css = ".time-left-text-in-account")
//    WebElement dayLeftText;

    }
}