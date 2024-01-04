Feature: Login Test

  @smoke
  Scenario: As a user, I should navigate to inventory page after login successfully with valid credentials
    Given I am on login page
    When  I enter user name "standard_user"
    And   I enter password "secret_sauce"
    And   I click on login button
    Then  I should login successfully

  @smoke
  Scenario Outline: As a user, I failed in login with invalid credentials
    Given I am on login page
    When  I enter invalid username "<username>"
    And   I enter invalid password "<password>"
    And   I click on login button
    Then  I should see an error message
    And   I should remain on the login page

    Examples:
      | username | password |
      | sauce    | lab      |
      | demo     | sauce    |