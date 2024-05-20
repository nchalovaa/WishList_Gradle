package com.wishlist.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignUpPage extends BasePage{
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

    public SignUpPage enterPersonalData(String name, String secondname, String email, String password) {
        type (firstname,name);
        type(lastname, secondname);
        type(emailaddress, email);
        type(userpassword, password);
        type(confirmpass, password);
        return this;
    }

    @FindBy(xpath = "//button[.='Sign Up']")
    WebElement signUpButton;
    public SignUpPage clickOnSignUpButtonRegistr() {
        click(signUpButton);
        return this;
    }

    @FindBy(xpath = "//button[.='Log In']")
    WebElement verifyButton;
    public SignUpPage verifySuccessButton(String text) {
        Assert.assertTrue(verifyButton.getText().contains(text));
        return this;
    }
    @FindBy(css = ".error-message")
    WebElement error;
    public SignUpPage verifyErrorMessage(String text) {
        Assert.assertTrue(error.getText().contains(text));
        return this;
    }
}
