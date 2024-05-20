package com.wishlist.tests.account;

import com.wishlist.pages.AccountPage;
import com.wishlist.pages.HomePage;
import com.wishlist.pages.LoginPage;
import com.wishlist.pages.SignUpPage;
import com.wishlist.tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteAccountPageTests extends TestBase {

    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private SignUpPage signupPage;
    WebDriver driver ;

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        signupPage = new SignUpPage(app.driver);
        driver=new ChromeDriver();

        if (!homePage.logInLinkPresent()) {
            homePage.clickOnLogOutLink();
        } else {
            homePage.clickOnLogInLink();
        }
    }

    @Test
    public void deleteAccount() {
        loginPage
                .enterPersonalData("dudkina@web.de", "Berlin2024!")
                .clickOnLogInButtonWithJs();
        accountPage
                .clickOnDeleteAccount("Delete Account");
        homePage.isHomePagePresent();
    }
    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
    }
}