Feature: As a user, I should be able to view the contact list
  @wip
  Scenario Outline: verify users can see all the contact names on the contact list
    Given user uses "<username>" and "<password>" to log in and on the dashboard page
    When the user clicks the contacts module
    Then verify the contact names are in the list
    Examples:
      | username | password    |
      | User12   | Userpass123 |
      | User42   | Userpass123 |
      | User72   | Userpass123 |
      | User102  | Userpass123 |