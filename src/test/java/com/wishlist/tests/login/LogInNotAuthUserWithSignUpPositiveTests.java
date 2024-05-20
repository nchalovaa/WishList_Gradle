package com.wishlist.tests.login;

import com.wishlist.pages.AccountPage;
import com.wishlist.pages.HomePage;
import com.wishlist.pages.LoginPage;
import com.wishlist.pages.SignUpPage;
import com.wishlist.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInNotAuthUserWithSignUpPositiveTests extends TestBase {
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private SignUpPage signupPage;

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        signupPage =new SignUpPage(app.driver);
        accountPage=new AccountPage(app.driver);

        if (!homePage.logInLinkPresent()) {
            homePage.clickOnLogOutLink();
        } else {
            homePage.clickOnLogInLink();
        }
    }
    // Проверка, что незарегистрированный пользователь c валидным email логинится через регистрацию
    @Test
    public void fillLogInFormViaRegistrationForm() {
        loginPage
                .enterPersonalData("dud@web.ua", "Berlin2024!")
                .clickOnLogInButtonWithJs()
                .clickOnSignUpLink();
        signupPage
                .enterPersonalData("Lena", "Dudkina", "dud@web.ua", "Berlin2024!", "Berlin2024!")
                .clickOnSignUpButtonRegistr();
        loginPage
                .enterPersonalData("dud@web.ua", "Berlin2024!")
                .clickOnLogInButtonWithJs();
        accountPage
                .verifyAccountPage("Create WishList");
    }

    @AfterMethod(enabled = false)
    @Override
    public void tearDown() {
        super.tearDown();
    }
}
