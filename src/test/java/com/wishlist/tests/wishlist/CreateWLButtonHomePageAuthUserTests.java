package com.wishlist.tests.wishlist;

import com.wishlist.pages.*;
import com.wishlist.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateWLButtonHomePageAuthUserTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        wishListPage = new WishListPage(app.driver);
        signupPage=new SignUpPage(app.driver);

        homePage
                .clickOnButtonCreateNewWishList();
        loginPage
                .enterPersonalData("dudkina@web.de", "Berlin2024!");
    }

    @Test
    public void clickOnCreateNewWishList() throws InterruptedException {
        accountPage
                .createWishListButton();
        wishListPage
                .fillWishListForm("Birthday","I have birthday soon", "15102025");
        Thread.sleep(1500);
        accountPage
                .verifyCardOfWishList();
    }
}