package com.wishlist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="first-name")
    WebElement yourname;
    @FindBy(id="last-name")
    WebElement yourlastname;
    @FindBy(id="email")
    WebElement youremail;
    @FindBy(id="password")
    WebElement yourpass;
    @FindBy(id="confirm-password")
    WebElement confirmyourmpass;
    @FindBy(xpath = "//button[.='Sign Up']")
    WebElement signUpButton;
    public SignUpPage enterPersonalData(String name, String secondname, String email, String password, String confpass) {
        type (yourname,name);
        type(yourlastname, secondname);
        type(youremail, email);
        type(yourpass, password);
        type(confirmyourmpass, password);
        click(signUpButton);

        return new SignUpPage(driver);
    }

    @FindBy(css = ".error-message")
    WebElement error;
    public SignUpPage verifyErrorMessage(String text) {
        Assert.assertTrue(error.getText().contains(text));
        return this;

    }
    @FindBy(css = "h2")
    WebElement verifySignUpButton;
    public SignUpPage verifySignUpButton(String text) {
        Assert.assertTrue(verifySignUpButton.getText().contains(text));
        return this;
    }

}