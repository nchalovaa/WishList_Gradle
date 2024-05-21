package com.wishlist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftPage extends BasePage {
    public GiftPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gift-link-custom")
    WebElement likWhere;
    @FindBy(id = "gift-name-custom")
    WebElement giftName;
    @FindBy(id="gift-price-custom")
    WebElement priceField;

    public GiftPage fillGiftForm(String link, String name, int price) {
        scrollToTopWithJS();
        type(likWhere, link);
        type(giftName, name);
        type(priceField, String.valueOf(price));
//добавить все остальные поля

        return new GiftPage(driver);
    }

    @FindBy(css = ".save-button-custom")
    WebElement saveButton;
    public GiftPage clickSaveButton() {
        click(saveButton);
        return new GiftPage(driver);
    }
}