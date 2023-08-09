Feature: Web Login and Dashboard Elements

  Background:
    Given the user is on login page
    When the user enters valid credentials
    And click Submit
    Then the user should be logged in successfully

  Scenario: Verify Time at Work is displayed on the dashboard
    Given the user is logged in and on the dashboard
    Then the "Time at Work" section should be displayed

  Scenario: Verify My Actions is displayed on the dashboard
    Given the user is logged in and on the dashboard
    Then the "My Actions" section should be displayed

  Scenario: Verify Quick Launch is displayed on the dashboard
    Given the user is logged in and on the dashboard
    Then the "Quick Launch" section should be displayed

  Scenario: Verify Buzz Latest Posts is displayed on the dashboard
    Given the user is logged in and on the dashboard
    Then the "Buzz Latest Posts" section should be displayed

  Scenario: Verify Employees on Leave Today is displayed on the dashboard
    Given the user is logged in and on the dashboard
    Then the "Employees on Leave Today" section should be displayed
