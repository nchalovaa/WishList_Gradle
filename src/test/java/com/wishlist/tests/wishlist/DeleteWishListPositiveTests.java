package com.wishlist.tests.wishlist;

import com.wishlist.pages.*;
import com.wishlist.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteWishListPositiveTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        signupPage = new SignUpPage(app.driver);
        wishListPage = new WishListPage(app.driver);
        wishListContentPage = new WishListContentPage(app.driver);

        if (!homePage.logInLinkPresent()) {
            homePage.clickOnLogOutLink();
        } else {
            homePage.clickOnLogInLink();
        }
        loginPage
                .enterPersonalData("dudkina@web.de", "Berlin2024!");
    }

    @Test
    public void deleteWishList() {
        accountPage
                .createWishListButton();
        wishListPage
                .fillWishListForm("Birthday", "I have birthday soon", "15102025");
        accountPage
                .clickOnWishlist();
        wishListContentPage
                .clickOnBasketToDelete()
                .clickOnOKbutton();
        accountPage
                .verifyAccountPage("Create WishList");
    }
}
