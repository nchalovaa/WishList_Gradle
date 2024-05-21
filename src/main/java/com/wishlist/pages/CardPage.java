package com.wishlist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardPage extends BasePage{
    public CardPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".delete-wl-button")
    WebElement basket;
    public CardPage clickOnBasketToDeleteCard(String confirm) {
        click(basket);
        if (confirm != null && confirm.equals("OK")) {
            driver.switchTo().alert().accept();
        } else if (confirm != null && confirm.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }

        return new CardPage(driver);
    }
    @FindBy(xpath = "//span[.='Add gift']")
    WebElement addGiftButton;
    public CardPage clickAddGiftButton() {
        click(addGiftButton);
        return new CardPage(driver);
    }

//    @FindBy( = "")
//    WebElement deleteAccountButton;


}