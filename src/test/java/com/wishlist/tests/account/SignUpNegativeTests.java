package com.wishlist.tests.account;

import com.wishlist.pages.HomePage;
import com.wishlist.pages.SignUpPage;
import com.wishlist.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpNegativeTests extends TestBase {

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
    // User ist already existed and tries to create second account with the same email
    @Test
    public void fillRegistrationFormtWithExistedEmailNegativeTest() {

        signupPage
                .enterPersonalData("Lena", "Dudkina", "dudkina@web.de", "Berlin2024!", "Berlin2024!")
                .verifyErrorMessage("Error");
    }

}