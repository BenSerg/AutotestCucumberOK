Feature: Group enter test

  Background:
    Given user is on home page
    When user clicks on group button

  Scenario Outline:
    And user sees first group
    And clicks on enter button
    Then <arg> should be seen
    Examples:
      | arg         |
      | Вы в группе |
    Scenario:
      And user enter moderate chapter with no moderate group
      Then non-exist message should be visible
  @SmokeTest
    Scenario:
      And user clicks on create group button
      And chooses public page
      And insert name in name_field
      And insert theme in theme_field
      And clicks on create button
      Then new group name should be equal to name in name_field and theme should be equal to theme in theme_field