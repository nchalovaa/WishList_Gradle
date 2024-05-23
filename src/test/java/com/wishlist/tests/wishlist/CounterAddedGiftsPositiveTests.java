package com.wishlist.tests.wishlist;

import com.wishlist.pages.*;
import com.wishlist.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CounterAddedGiftsPositiveTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        signupPage = new SignUpPage(app.driver);
        wishListPage = new WishListPage(app.driver);
        giftPage = new GiftPage(app.driver);
        wishListContentPage = new WishListContentPage(app.driver);

        if (!homePage.logInLinkPresent()) {
            homePage.clickOnIconAccount();
        } else {
            homePage.clickOnLogInLink();
        }
        loginPage
                .enterPersonalData("dudkina@web.de", "Berlin2024!");
        accountPage
                .createWishListButton();
        wishListPage
                .fillWishListForm("Birthday", "I have birthday soon", "15102025");
    }

    @Test
    private void CounterOffAddedGiftsTest() {
        int counter = accountPage.getGiftCount();     //0 gifts
        accountPage
                .clickOnAddGiftButton();
        giftPage.
                fillGiftform("https://www.douglas.de/de",
                        "Chanel Allure", "100",
                        "USD",
                        "I want this",
                        "");
        wishListContentPage
                .clickOnGoToWishLists();
        int newCounter = accountPage.getGiftCount();  //1 gift
        accountPage
                .clickOnAddGiftButton();
        giftPage
                .fillGiftform("https://www.douglas.de/de",
                        "Chanel Allure", "100",
                        "USD",
                        "I want this",
                        "");
        wishListContentPage
                .clickOnGoToWishLists();
        newCounter = accountPage.getGiftCount();     //2 gifts
        Assert.assertEquals(newCounter, counter);

    }
}
