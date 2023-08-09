Feature: Web Login

  Scenario: Login with empty username
    Given the user is on login page
    When enters empty username
    And click Submit
    Then an user required message should be displayed

  Scenario: Login with empty password
    Given the user is on login page
    When enters empty password
    And click Submit
    Then an password required message should be displayed

  Scenario: Login with incorrect password
    Given the user is on login page
    When the user enters incorrect password
    And click Submit
    Then an error message should be displayed

  Scenario: Verify presence of login elements
    Given the user is on login page
    Then the username input field should be displayed
    And the password input field should be displayed
    And the login button should be displayed

  Scenario: Successful login
    Given the user is on login page
    When the user enters valid credentials
    And click Submit
    Then the user should be logged in successfully