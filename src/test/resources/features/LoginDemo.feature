Feature: Test login functionality

  Scenario Outline: Check login is successful with valid credentials

    Given browser is open on login page
    When user enters <username> and <password>
    And submit login button
    Then user is navigated to the home page

    Examples:
      | username    | password        |
      | technoPol30 | technoPolis2022 |