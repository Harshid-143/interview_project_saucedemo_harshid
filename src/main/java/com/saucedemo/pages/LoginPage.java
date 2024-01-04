package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "user-name")
    WebElement userNameField;

    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "login-button")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h3[text()]")
    WebElement loginError;

    public void enterUserName(String username) {
        sendTextToElement(userNameField, username);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }


    public void loginToApplication(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickOnLoginButton();
    }

    public String getMessageAfterLoginUnSuccessfully() {
        String message = getTextFromElement(loginError);
        return message;
    }

    public String pageTitle(){
        String title = driver.getTitle();
        return title;
    }
}
