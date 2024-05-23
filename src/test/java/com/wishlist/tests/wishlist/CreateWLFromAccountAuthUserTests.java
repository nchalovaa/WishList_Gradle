package com.wishlist.tests.wishlist;

import com.wishlist.pages.AccountPage;
import com.wishlist.pages.HomePage;
import com.wishlist.pages.LoginPage;
import com.wishlist.pages.WishListPage;
import com.wishlist.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateWLFromAccountAuthUserTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        wishListPage = new WishListPage(app.driver);

        if (!homePage.logInLinkPresent()) {
            homePage.clickOnIconAccount();
        } else {
            homePage.clickOnLogInLink();
        }
        loginPage
                .enterPersonalData("dudkina@web.de", "Berlin2024!");
    }

    @Test
    public void clickOnIWantWishList() throws InterruptedException {
        accountPage
                .createWishListButton();
        wishListPage
                .fillWishListForm("Birthday","I have birthday soon", "15102025");
        Thread.sleep(1500);
        accountPage
                .verifyCardOfWishList();
    }
}