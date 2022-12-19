Feature: Login

  Scenario: Login
    Given User Launch Chrome Driver
    When User opens URL "https://ok.ru/dk?st.cmd=anonymMain"
    And User enter Email "<technoPol11>"
    And User enter Password as "<technoPolis2022>"
    And User clicks on Login
    Then User name should be "<technoPol11 technoPol11>"



