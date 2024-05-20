package com.wishlist.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    //@FindBy(css=".create-wishlist-button")
    @FindBy(xpath = "//a[contains(text(),'Create WishList')]")
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
        return this;
    }

    @FindBy(css = "ul.nav-list :nth-child(3)")
    WebElement clickOnLogOut;

    public AccountPage clickOnLogoutLinkAccount() {
        click(clickOnLogOut);
        return this;
    }

    @FindBy(css = ".delete-button")
    WebElement clickDeleteButton;
    @FindBy(css = ".close-button")
    WebElement closeButton;
    @FindBy(css = "p")
    WebElement alertWindow;

    public AccountPage clickOnDeleteAccount(String confirm) {
        click(clickDeleteButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            if (confirm != null && confirm.equals("Delete Account")) {
                alert.accept();
            } else if (confirm != null && confirm.equals("x")) {
                alert.dismiss();
            }
        } catch (TimeoutException e) {
        }
        return this;
    }

    @FindBy(css = ".delete-account-button")
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

    @FindBy(css = "ant-row")
    WebElement cardExisted;

    public AccountPage verifyCard() {
        Assert.assertTrue(isElementPresent(cardExisted));
        return this;
    }
}
