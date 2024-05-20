package com.wishlist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="first-name")
    WebElement firstname;
    @FindBy(id="last-name")
    WebElement lastname;
    @FindBy(id="email")
    WebElement emailaddress;
    @FindBy(id="password")
    WebElement userpassword;
    @FindBy(id="confirm-password")
    WebElement confirmpass;

    public SignUpPage enterPersonalDatasafe(String name, String secondname, String email, String password, String confpass) {
        safeType(firstname, name);
        safeType(lastname, secondname);
        safeType(emailaddress, email);
        safeType(userpassword, password);
        safeType(confirmpass, confpass);
        return this;
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
    public SignUpPage enterPersonalData(String name, String secondname, String email, String password, String confpass) {
        type (yourname,name);
        type(yourlastname, secondname);
        type(youremail, email);
        type(yourpass, password);
        type(confirmyourmpass, password);
        return this;
    }


    @FindBy(xpath = "//button[.='Sign Up']")
    WebElement signUpButton;
    public SignUpPage clickOnSignUpButtonRegistr() {
        safeClick(signUpButton);
        click(signUpButton);
        return this;
    }

    //    @FindBy(xpath = "//button[.='Log In']")
//    WebElement verifyButton;
//    public SignUpPage verifySuccessButton(String text) {
//        Assert.assertTrue(verifyButton.getText().contains(text));
//        return this;
//    }
    @FindBy(css = ".error-message")
    WebElement error;
    public SignUpPage verifyErrorMessage(String text) {
        Assert.assertTrue(error.getText().contains(text));
        return this;

    }
    @FindBy(xpath = ".save-button")
    WebElement verifySignUpButton;
    public SignUpPage verifySignUpButton(String text) {
        return this;
    }
}