Feature: Test login functionality
  Scenario Outline: Check login is successful with valid credentials

    Given browser is open on login page
    When user enters <login> and <password>
    And submit login button
    Then user is navigated to the home page and username should be equal to <username>

    Examples:
      | login       | password        | username                |
      | technoPol30 | technoPolis2022 | Bot Receiver            |
      | technoPol29 | technoPolis2022 | technoPol29 technoPol29 |