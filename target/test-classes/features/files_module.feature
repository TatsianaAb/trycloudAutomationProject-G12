Feature: As a user, I should be able to access to Files module
  US:As a user, I should be able to access to Files module

  Scenario Outline: verify users can access to Files module
    Given user uses "<username>" and "<password>" to log in and on the dashboard page
    When the user clicks the "Files" module
    Then verifies the page title is "Files - Trycloud"
    Examples:
      | username | password    |
      | User12   | Userpass123 |
      | User42   | Userpass123 |
      | User72   | Userpass123 |
      | User102  | Userpass123 |
  @wip
  Scenario Outline: verify users can select all the uploaded files from the page
    Given user uses "<username>" and "<password>" to log in and on the dashboard page
    When the user clicks the "Files" module
    And user click the top-left checkbox of the table
    Then verify all the files are selected
    Examples:
      | username | password    |
      | User12   | Userpass123 |
      | User42   | Userpass123 |
      | User72   | Userpass123 |
      | User102  | Userpass123 |
