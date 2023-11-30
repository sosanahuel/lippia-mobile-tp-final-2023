Feature: As a user, I want to be able to add times and dates to my projects

  @timeEntryDelete
  Scenario Outline: Add time to a project and delete
    Given the user successfully logged into the app
    When the user enters their <email>, <password>
    And the user sets a time <hour> <minutes>
    And the user adds to the project <project> and description <text>
    And the user saves the time entry
    Then the user checks their saved project <text>
    And deletes the task by backend from the time entry '<text>' in the project
    Examples:
      | email             | password  | text            | project | hour | minutes |
      | xnahuex@gmail.com | Asdasd123 | crowdarEliminar | Mobile  | 14   | 15      |

  @timeEntryNoSave
  Scenario Outline: Add time to project and unsaved
    Given the user successfully logged into the app
    When the user enters their <email>, <password>
    And the user sets a time <hour> <minutes>
    And the user adds to the project <project> and description <text>
    And the user cancels the save
    Then the user checks their unsaved project <text>
    Examples:
      | email             | password  | text    | project | hour | minutes |
      | xnahuex@gmail.com | Asdasd123 | no save | Mobile  | 14   | 15      |


  @DateEntry
  Scenario Outline: Add date to project
    Given the user successfully logged into the app
    When the user enters their <email>, <password>
    And the user sets a time <hour> <minutes>
    And the user enters a date '<date>'
    And the user sets start time '<Starthour>' '<Startminutes>'
    And confirms the data
    And the user adds to the project <project> and description <text>
    And the user saves the time entry
    Then the user checks their saved project <text>
    Examples:
      | email             | password  | text      | project | hour | minutes | date       | Starthour | Startminutes |
      | xnahuex@gmail.com | Asdasd123 | DiaPueblo | Mobile  | 23   | 59      | 30-08-2023 | 00        | 00           |


  @DarkModeLogout
  Scenario Outline: Set dark mode and logout
    Given the user successfully logged into the app
    When the user enters their <email>, <password>
    And selects from the hamburger menu
    And selects settings
    And switches to dark mode
    And logs out
    Then the user is logged out
    Examples:
      | email             | password  |
      | xnahuex@gmail.com | Asdasd123 |