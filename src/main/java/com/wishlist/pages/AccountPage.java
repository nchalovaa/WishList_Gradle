package com.wishlist.pages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(css = ".create-wishlist-button")
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

    public AccountPage clickOnDeleteAccount() {
        safeClick(clickDeleteButton);
        return new AccountPage(driver);
    }
    @FindBy(xpath = "//p[contains(text(),'Do you want to delete your account?')]")
    WebElement modalContent;
    public WebElement findModalContent() {
        return driver.findElement(By.xpath("//p[contains(text(),'Do you want to delete your account?')]"));
    }
//    @FindBy(xpath = "//p[contains(text(),'Do you want to delete your account?')]")
//    WebElement modalContent;
//public WebElement findModalContent() {
//    return driver.findElement((By) modalContent);
//}

    public AccountPage selectDelete(String confirm) {WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            WebElement modalContentElement = wait.until(ExpectedConditions.visibilityOf(modalContent));

            if (modalContentElement.getText().contains("Do you want to delete your account?")) {
                if (confirm != null && confirm.equals("Delete Account")) {
                    driver.switchTo().alert().accept();
                } else if (confirm != null && confirm.equals("x")) {
                    driver.switchTo().alert().dismiss();
                }
            } else {
                System.out.println("Модальное окно не содержит ожидаемого текста.");
            }

        } catch (TimeoutException e) {
            System.out.println("Модальное окно не было загружено в течение 3 секунд.");
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

    @FindBy(css = "ant-card")
    WebElement cardExisted;

    public AccountPage verifyCard() {
        Assert.assertTrue(isElementPresent(cardExisted));
        return this;
    }

    @FindBy(css = ".ant-card-head-title")
    WebElement cardTitle;
    public AccountPage clickOnTitleCard() {
        click(cardTitle);
        return new AccountPage(driver);
    }
}