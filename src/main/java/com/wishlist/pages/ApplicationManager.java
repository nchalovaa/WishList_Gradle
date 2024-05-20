package com.wishlist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager {
    public WebDriver driver;
    String browser;

    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    SignUpPage signupPage;
    WishListPage wishListPage;
    AboutUsPage aboutUsPage;
    PrivacyPolicyPage privacyPolicyPage;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public AccountPage getAccountPage() {
        return accountPage;
    }

    public SignUpPage getSignupPage() {
        return signupPage;
    }

    public WishListPage getWishListPage() {
        return wishListPage;
    }

    public AboutUsPage getAboutUsPage() {
        return aboutUsPage;
    }

    public PrivacyPolicyPage getPrivacyPolicyPage() {
        return privacyPolicyPage;
    }

    public void init() {

        {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {

                System.setProperty("webdriver.gecko.driver", "C:/Tools/geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", "C:/Tools/msedgedriver.exe");
                driver = new EdgeDriver();
            }

            driver.get("http://localhost:3000/");
            driver.manage().window().maximize();
            //driver.manage().window().setSize(new Dimension(1920,1080));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }
}

//    public WebDriver driver;
//    String browser;
//    //    private static final Duration WAIT_MILLIS_TIMEOUT = Duration.ofMillis(5000);
////    private static final Duration WAIT_MILLIS_WAIT = Duration.ofMillis(500);
//    public static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));
//
//
//    public ApplicationManager(String browser) {
//        this.browser = browser;
//    }
//
//    public WebDriver getDriver() {
//        return driver;
//    }
