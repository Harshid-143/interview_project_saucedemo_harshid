Feature: End to end testing for placing an order

  @smoke
  Scenario: As a user, I adds items to the cart, proceeds to checkout and completes the purchase successfully
    Given I am on login page
    When  I enter "standard_user" username
    And   I enter "secret_sauce" password
    And   I add items to the shopping cart
    And   I proceed to checkout
    And   I provide shipping information "Ronny" firstname and "Watson" lastname and "E1 7AA" postalCode
    And   I complete the purchase
    Then  I should receive an order confirmation