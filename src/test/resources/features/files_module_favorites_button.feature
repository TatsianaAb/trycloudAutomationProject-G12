Feature: As a user, I should be able to access to Files module - Favorites button

  Story: As a user, I should be able to add file to favorites

  @wip
  Scenario Outline: Verify users to add files to Favorites
    Given user uses "<username>" and "<password>" to log in and on the dashboard page
    When the user clicks the "Files" module
    When the user clicks action-icon from first file on the page
    And user choose the "Add to favorites" option
    And user click the "Favorites" sub-module on the left side
    Then Verify the chosen file "UploadTest" is listed on the table
    Examples:
      | username | password    |
      | User5    | Userpass123 |
      | User35   | Userpass123 |
      | User65   | Userpass123 |
      | User95   | Userpass123 |