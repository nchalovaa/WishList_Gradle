package com.wishlist.tests.wishlist;

import com.wishlist.pages.*;
import com.wishlist.tests.TestBase;
import org.testng.annotations.BeforeMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CounterDaysLeftPositiveTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        wishListPage = new WishListPage(app.driver);
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
                .fillWishListForm("Birthday","I have birthday soon", "15102025");
    }

}
