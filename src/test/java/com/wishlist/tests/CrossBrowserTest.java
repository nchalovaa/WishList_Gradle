package com.wishlist.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class CrossBrowserTest {
    WebDriver driver;

    @BeforeMethod(enabled = false)
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
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
        driver.manage().window().maximize();
    }

    @Test
    public void crossBrowserTest() throws InterruptedException {
        String[] browsers = {"chrome", "edge", "firefox"};

        for (String browser : browsers) {
            setup(browser);
            driver.get("http://localhost:3000/");
            Thread.sleep(2000); // Пауза в 2 секунды
            // Дополнительные шаги и проверки
        }
        teardown();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }

    }
}
