package com.wishlist.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    //WebDriver driver;
    JavascriptExecutor js;
    public WebDriver driver;
    FluentWait<WebDriver> wait;
    public static final Duration WAIT_SEC = Duration.ofSeconds(5);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
//        js = (JavascriptExecutor) driver;
//        wait = new FluentWait<>(driver) // Инициализируем FluentWait
//                .withTimeout(Duration.ofSeconds(15)) // Устанавливаем таймаут ожидания
//                .pollingEvery(Duration.ofSeconds(1)) // Устанавливаем периодичность проверки
//                .ignoring(NoSuchElementException.class) // Игнорируем исключение NoSuchElementException
//                .ignoring(StaleElementReferenceException.class); // Игнорируем исключение StaleElementReferenceException
    }

    protected boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    //Использование ожидания доступности элемента click
    public void safeClick(WebElement element) {
        try {
            element.click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
    }

    //Использование ожидания доступности элемента type
    public void safeType(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (StaleElementReferenceException e) {
            element = wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
        }
    }

    public void clickWithJS(WebElement element, int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        pause(500);
        click(element);
    }

    public void scrollToTopWithJS() {
        js.executeScript("window.scrollTo(0, 0)");
    }


    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());

        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
    }
}