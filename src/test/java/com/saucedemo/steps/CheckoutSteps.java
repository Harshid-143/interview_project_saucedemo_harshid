package com.saucedemo.steps;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutSteps {

    @When("I enter {string} username")
    public void iEnterUsername(String username) {
        new LoginPage().enterUserName(username);

    }

    @And("I enter {string} password")
    public void iEnterPassword(String password) {
        new LoginPage().enterPassword(password);
        new LoginPage().clickOnLoginButton();

    }

    @When("I add items to the shopping cart")
    public void iAddItemSToTheShoppingCart() {
        new InventoryPage().clickOnAddToCartButtons();
        new InventoryPage().clickOnShoppingCartLink();
    }

    @And("I proceed to checkout")
    public void iProceedToCheckout() {
        new CartPage().clickOnCheckoutButton();
    }

    @And("I provide shipping information {string} firstname and {string} lastname and {string} postalCode")
    public void iProvideShippingInformationFirstnameAndLastnameAndPostalCode(String firstname, String lastname, String postalCode) {
        new CheckoutPage().checkoutWithInformation(firstname,lastname,postalCode);
    }

    @And("I complete the purchase")
    public void iCompleteThePurchase() {
        new CheckoutPage().clickOnFinishButton();
    }

    @Then("I should receive an order confirmation")
    public void iShouldReceiveAnOrderConfirmation() {
        String expectedMessage = "Thank you for your order!";
        String actualMessage = new CheckoutPage().getMessageAfterCheckoutSuccessfully();
       Assert.assertEquals(actualMessage,expectedMessage);
    }

}
