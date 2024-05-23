package com.wishlist.tests.login;

import com.wishlist.pages.HomePage;
import com.wishlist.pages.LoginPage;
import com.wishlist.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAuthUserNegativeTests extends TestBase {
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);

        if (!homePage.logInLinkPresent()) {
            homePage.clickOnLogOutLink();
        } else {
            homePage.clickOnLogInLink();
        }
    }
    // Нет errorMessage для пустых полей ввода.Проверяю, что после клика на кнопку Login страница не меняется
    @Test
    public void loginWithoutPasswordNegativeTest() {
        loginPage
                .enterPersonalData("dudkina@web.de", "")
                .verifyLoginForm("Log In");
    }

    @Test
    public void loginWithoutEmaildNegativeTest() {
        loginPage
                .enterPersonalData("", "Berlin2024!")
                .verifyLoginForm("Log In");
    }

    @Test
    public void loginWithWrongEmaildNegativeTest() {
        loginPage
                .enterPersonalData("dudkina@web.na", "Berlin2024!")
                .verifyErrorMessage("Error");
    }

    @Test
    public void loginWithWrongPasswordNegativeTest() {
        loginPage
                .enterPersonalData("dudkina@web.de", "Muenchen2024$")
                .verifyErrorMessage("Error");
    }

}