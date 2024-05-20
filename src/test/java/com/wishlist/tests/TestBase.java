package com.wishlist.tests;

import com.wishlist.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager("chrome");
    public WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    SignUpPage signupPage;
    AboutUsPage aboutUsPage;
    PrivacyPolicyPage privacyPolicyPage;
    WishListPage wishListPage;

    @BeforeMethod
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        app = new ApplicationManager(browser);
        driver = app.getDriver();
        app.init();

        // app = new ApplicationManager(Browser.CHROME.browserName());
        // app.init();

        //driver = new ChromeDriver();
        //driver.get("http://localhost:3000/");
        //driver.manage().window().maximize();
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        signupPage = new SignUpPage(app.driver);
        aboutUsPage=new AboutUsPage(app.driver);
        privacyPolicyPage= new PrivacyPolicyPage(app.driver);
        wishListPage=new WishListPage(app.driver);

        app.driver.quit();
    }
}