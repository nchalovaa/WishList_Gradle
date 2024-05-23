package com.wishlist.tests.homepage;

import com.wishlist.pages.*;
import com.wishlist.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private SignUpPage signupPage;
    private AboutUsPage aboutusPage;
    private WishListPage wishListPage;
    private PrivacyPolicyPage privatepolicyPage;

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        signupPage = new SignUpPage(app.driver);
        aboutusPage = new AboutUsPage(app.driver);
        wishListPage = new WishListPage(app.driver);
        privatepolicyPage=new PrivacyPolicyPage(app.driver);

        if (!homePage.logInLinkPresent()) {
            homePage.clickOnLogOutLink();
        }
    }

    @Test
    public void clickOnAboutUsLinkTest() {
        homePage.clickOnAboutUsLink();
        aboutusPage.verifyAboutUs("convenient");
    }

    @Test
    public void clickOnLogInLink() {
        homePage.clickOnLogInLink();
        loginPage.verifyLoginForm("Log In");
    }

    @Test
    public void clickOnSignUpLink() {
        homePage.clickOnSignUpLink();
        signupPage.verifySignUpButton("Sign Up");
    }

    @Test
    public void clickOnCreateNewWishList() {
        homePage
                .clickOnButtonCreateNewWishList();
        loginPage.verifyLoginForm("Log In");
    }

    @Test
    public void clickOnIwantWishListButton() {
        homePage
                .clickIwantWishListButtonWithJS();
        loginPage.verifyLoginForm("Log In");
    }

    @Test
    public void cliclOnPrivacyPolicyTest() {
        homePage.clickOnPrivacyPolicyLink();
        privatepolicyPage.verifyPolicy("PrivacyPolicy");

    }

    @Test
    public void clickOnGitHubButtonTest(){
        homePage.clickOnGitHubButton();
    }
}
