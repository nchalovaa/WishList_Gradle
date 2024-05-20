package com.wishlist.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage {

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "wishlist-name")
    WebElement name;
    public WishListPage inputNameWishlist(String title) {
        scrollToTopWithJS();
        type(name, title);
        return this;
    }
    @FindBy(id = "comment")
    WebElement comments;
    public WishListPage inputComment(String comment) {
        type(comments, comment);
        return this;
    }
    @FindBy(id = "event-date")
    WebElement eventdate;
    public WishListPage inputEventDate(String date) {
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
        return this;
    }
    @FindBy(css = ".save-button-custom")
    WebElement savebutton;
    public WishListPage clickOnSaveButton() {
        click(savebutton);
        return this;
    }

}
