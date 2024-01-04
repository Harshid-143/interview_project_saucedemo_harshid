package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends Utility {

    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement getSuccessfullyLoginMessage;

    @CacheLookup
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement cartItem1;

    @CacheLookup
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement cartItem2;

    @CacheLookup
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCartLink;

    public String getMessageAfterSuccessfullyLogin() {
        String message = getTextFromElement(getSuccessfullyLoginMessage);
        return message;
    }

    public void clickOnAddToCartButtons() {
        clickOnElement(cartItem1);
        clickOnElement(cartItem2);
    }

    public void clickOnShoppingCartLink(){
        clickOnElement(shoppingCartLink);
    }
}
