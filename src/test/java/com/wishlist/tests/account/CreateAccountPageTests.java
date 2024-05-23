package com.wishlist.tests.account;

import com.wishlist.pages.*;
import com.wishlist.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountPageTests extends TestBase {

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
                .enterPersonalData("Lena", "Dudkina", "dudkina@web.de", "Berlin2024!", "Berlin2024!");
        loginPage
                .enterPersonalData("dudkina@web.de", "Berlin2024!");
        accountPage
                .verifyAccountPage("Create WishList");
    }

    @AfterMethod(enabled = false)
    public void postcondition(){
        accountPage
                .selectDeleteAccountButton();
        homePage.isHomePagePresent();

    }

}
