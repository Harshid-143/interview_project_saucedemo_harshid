package com.saucedemo.steps;

import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    @Given("I am on login page")
    public void iAmOnLoginPage() {
    }

    @When("I enter user name {string}")
    public void iEnterUserName(String username) {
        new LoginPage().enterUserName(username);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        new LoginPage().enterPassword(password);
    }

    @And("I click on login button")
    public void iClickOnLoginButton(){
        new LoginPage().clickOnLoginButton();
    }

    @Then("I should login successfully")
    public void iShouldLoginSuccessfully() {
        String expectedMessage = "Products";
        String actualMessage = new InventoryPage().getMessageAfterSuccessfullyLogin();
        Assert.assertEquals(actualMessage, expectedMessage);
    }


    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualMessage = new LoginPage().getMessageAfterLoginUnSuccessfully();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @And("I should remain on the login page")
    public void iShouldRemainOnTheLoginPage() {
        Assert.assertEquals(new LoginPage().pageTitle(), "Swag Labs");
    }

    @When("I enter invalid username {string}")
    public void iEnterInvalidUsername(String username) {
        new LoginPage().enterUserName(username);
    }

    @And("I enter invalid password {string}")
    public void iEnterInvalidPassword(String password) {
        new LoginPage().enterPassword(password);
    }
}
