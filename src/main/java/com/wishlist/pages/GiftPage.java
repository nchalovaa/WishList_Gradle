package com.wishlist.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GiftPage extends BasePage {
    public GiftPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gift-link-custom")
    WebElement likWhere;

    @FindBy(id = "gift-name-custom")
    WebElement giftName;

    @FindBy(id = "gift-price-custom")
    WebElement priceField;

    @FindBy(css = ".currency-select")
    WebElement currencyField;

    @FindBy(id = "gift-comment-custom")
    WebElement giftcomment;

    @FindBy(css = ".file-input-text")
    WebElement uploadPhotoWindow;

    @FindBy(css = ".save-button-custom")
    WebElement saveButton;
    @FindBy( id="link-custom")
    WebElement linkImgField;

    public GiftPage fillGiftform(String link, String name, String price, String currency, String comment, String linkImg) {
        type(likWhere, link);
        type(giftName, name);
        type(priceField, String.valueOf(price));

        click(currencyField);
        Select select = new Select(currencyField);
        select.selectByVisibleText(currency);

        type(giftcomment, comment);

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementById('.file-input-text').style.display = 'block';");
//        js.executeScript("document.getElementById('.file-input-text').setAttribute('type', 'file');");
//        js.executeScript("document.getElementById('.file-input-text').setAttribute('value', 'C:/Tools/Libre.jpg');");

        click(uploadPhotoWindow);
        uploadFileRobot("C:\\Tools\\Libre.jpg");
        // uploadPhotoWindow.sendKeys(photoPath);
        //  uploadFile(uploadPhotoWindow,photoPath);

        type(linkImgField, linkImg);

        hideFooter();
        click(saveButton);

        return new GiftPage(driver);
    }
}

//-----------Вывод в консоль всех полей внутри currency------------------
//        List<WebElement> options=select.getOptions();
//        System.out.println(select.getFirstSelectedOption().getText() + "is first");
//        for (int i = 0; i < options.size(); i++) {
//            System.out.println(options.get(i).getText());
//
//------------Второй вариант выбора currency------------------------------
//        currencyField.sendKeys(currency);
//        currencyField.sendKeys(Keys.ENTER);



//    public GiftPage enterGiftLink(String link) {
//        type(likWhere, link);
//        return this;
//    }


//    public GiftPage enterGiftName(String name) {
//        type(giftName, name);
//        return this;
//    }


//    public GiftPage enterGiftPrice(String price) {
//        type(priceField, String.valueOf(price));
//        return this;
//    }

//    public GiftPage chooseCurrency(String currency) {
//        click(currencyField);
//        currencyField.sendKeys(currency);
//        currencyField.sendKeys(Keys.ENTER);
//        return this;
//    }

//    public GiftPage enterGiftComment(String comment) {
//        type(giftcomment, comment);
//        return this;
//    }

//    public GiftPage enterPhoto(String photoPath) {
//        uploadPhotoWindow.sendKeys(photoPath);
//        return this;
//    }

//    public GiftPage clickSaveButton() {
//        click(saveButton);
//        return new GiftPage(driver);
//    }