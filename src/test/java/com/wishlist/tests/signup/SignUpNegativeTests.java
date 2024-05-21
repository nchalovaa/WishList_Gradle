package com.wishlist.tests.signup;

import com.wishlist.pages.AccountPage;
import com.wishlist.pages.HomePage;
import com.wishlist.pages.LoginPage;
import com.wishlist.pages.SignUpPage;
import com.wishlist.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpNegativeTests extends TestBase {
    private HomePage homePage;
    private SignUpPage signupPage;

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        signupPage = new SignUpPage(app.driver);

        if (!homePage.logInLinkPresent()) {
            homePage.clickOnLogOutLink();
        } else {
            homePage.clickOnSignUpLink();
        }
    }

    @Test
    public void fillRegistrationFormtWithExistedEmailNegativeTest() {

        signupPage
                .enterPersonalDatasafe("Lena", "Dudkina", "dudkina@web.ru", "Berlin2024!", "Berlin2024!")
                .clickOnSignUpButtonRegistr()
                .verifyErrorMessage("Error");
    }
}
