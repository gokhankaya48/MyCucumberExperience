Feature: Citizenship Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to CitizenShip

  Scenario Outline: Create a Citizenship with parameter
    When Create a CitizenShip name as "<name>" shortkod as "<shortName>"
    Then Success message should be displayed

    When Create a CitizenShip name as "<name>" shortkod as "<shortName>"
    Then Already exist message should be displayed

    When user delete name as "<name>"
    Then Success message should be displayed

    Examples:
      | name    | shortName   |
      | gokCS1d | gokCS1short |
      | gokCS2d | gokCS2short |
      | gokCS3d | gokCS3short |
      | gokCS4d | gokCS4short |
      | gokCS5d | gokCS5short |

