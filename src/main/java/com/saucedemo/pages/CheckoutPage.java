package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends Utility {

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "first-name")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(id = "last-name")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(id = "postal-code")
    WebElement zipOrPostalCode;


    @CacheLookup
    @FindBy(id = "continue")
    WebElement continueButton;

    @CacheLookup
    @FindBy(id = "finish")
    WebElement finishButton;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Thank you for your order!')]")
    WebElement getSuccessfullyCheckoutMessage;

    public void enterFirstName(String firstname) {
        sendTextToElement(firstNameField, firstname);
    }

    public void enterLastName(String lastname) {
        sendTextToElement(lastNameField, lastname);
    }

    public void enterZipOrPostalCode(String postalCode) {
        sendTextToElement(zipOrPostalCode, postalCode);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public void clickOnFinishButton() {
        clickOnElement(finishButton);
    }

    public String getMessageAfterCheckoutSuccessfully() {
        String message = getTextFromElement(getSuccessfullyCheckoutMessage);
        return message;
    }

    public void checkoutWithInformation(String firstname, String lastname, String postalCode) {
        enterFirstName(firstname);
        enterLastName(lastname);
        enterZipOrPostalCode(postalCode);
        clickOnContinueButton();
    }

}
