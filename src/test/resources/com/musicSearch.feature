Feature: Music search
  Scenario Outline: Add a music
    Given user is on home page
    When User clicks on music toolbar
    And User clicks on search icon
    And User enter Author as "<author>"
    And User clicks on music search button
    Then User author should be "<songAuthor>"

  Examples:
  | author       | songAuthor   |
  | Thomas Mraz  | Thomas Mraz  |
  | Taylor Swift | Taylor Swift |
  | Selena Gomez | Selena Gomez |

