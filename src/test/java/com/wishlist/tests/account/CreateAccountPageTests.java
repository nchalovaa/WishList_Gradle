package com.wishlist.tests.account;

import com.wishlist.pages.AccountPage;
import com.wishlist.pages.HomePage;
import com.wishlist.pages.LoginPage;
import com.wishlist.pages.SignUpPage;
import com.wishlist.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountPageTests extends TestBase {
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private SignUpPage signupPage;

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        signupPage = new SignUpPage(app.driver);

        if (!homePage.logInLinkPresent()) {
            homePage.clickOnLogOutLink();
        } else {
            homePage.clickOnSignUpLink();
        }
    }

    @Test
    public void fillRegistratiónForm() {
//        Random random = new Random();
//        int i = random.nextInt(1000) + 1000;
//        signupPage
//                .enterPersonalData("Lena", "Dudkina", "dudkina" + i + "@web.de", "Berlin2024!")
//                .clickOnSignUpButtonRegistr();
//                accountPage-.                        .verifyAccountPage("Create WishList");
        signupPage
                .enterPersonalDatasafe("Lena", "Dudkina", "dudkina@web.de", "Berlin2024!", "Berlin2024!")
                .clickOnSignUpButtonRegistr();
        loginPage
                .enterPersonalData("dudkina@web.de", "Berlin2024!")
                .clickOnLogInButtonWithJs();
        accountPage
                .verifyAccountPage("Create WishList");
    }

}
