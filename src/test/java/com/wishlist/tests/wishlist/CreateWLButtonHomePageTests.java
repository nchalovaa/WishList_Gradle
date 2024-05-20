package com.wishlist.tests.wishlist;

import com.wishlist.pages.*;
import com.wishlist.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateWLButtonHomePageTests extends TestBase {
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private WishListPage wishlistPage;

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        wishlistPage = new WishListPage(app.driver);
        homePage
                .clickOnButtonCreateNewWishList();
        loginPage
                .enterPersonalData("dudkina@web.de", "Berlin2024!")
                .clickOnLogInButtonWithJs();
    }

    @Test
    public void clickOnCreateNewWishList() throws InterruptedException {
        accountPage
                .createWishListButton();
        wishlistPage
                .inputNameWishlist("Birthday")
                .inputComment("Скоро у меня день рождения")
                .inputEventDate("15/08/2024")
                .clickOnSaveButton();
        Thread.sleep(1500);
        //accountPage
        //       .verifyCard();

    }

    @AfterMethod(enabled = false)
    @Override
    public void tearDown() {
        super.tearDown();
    }


}
