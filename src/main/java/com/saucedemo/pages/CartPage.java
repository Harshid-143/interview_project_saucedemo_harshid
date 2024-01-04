package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends Utility {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public void clickOnCheckoutButton() {
        clickOnElement(checkoutButton);
    }
}
