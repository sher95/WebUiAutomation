Feature: Web Login
  Scenario: User should be able to login with valid credentials
    Given the user is on login page
    When the user enters valid credentials
    And click Submit
    Then the user should be logged in successfully