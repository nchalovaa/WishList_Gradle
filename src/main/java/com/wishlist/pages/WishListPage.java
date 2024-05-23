package com.wishlist.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class WishListPage extends BasePage {

    public WishListPage(WebDriver driver) {
        super(driver);
    }
    public

    @FindBy(id = "wishlist-name")
    WebElement name;
    @FindBy(id = "comment")
    WebElement comments;
    @FindBy(id = "event-date")
    WebElement eventdate;
    @FindBy(css = ".save-button-custom")
    WebElement savebutton;

    public WishListPage fillWishListForm(String title, String comment, String date ) {
        scrollToTopWithJS();
        type(name, title);
        type(comments, comment);
        click(eventdate);
        String os = System.getProperty("os.name");
        System.out.println("My OS is " + os);
        if (os.startsWith("Mac")) {
            eventdate.sendKeys(Keys.COMMAND, "a");
        } else {
            eventdate.sendKeys(Keys.CONTROL, "a");
        }
        eventdate.sendKeys(date);
        eventdate.sendKeys(Keys.ENTER);
        click(savebutton);

        return new WishListPage(driver);
    }

}



