Feature: Country Multi Scenario

  Background: #before senaryo
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to country

  @Regression
  Scenario: Create a Country
    When Create a country
    Then Success message should be displayed
  @Regression
  Scenario: Create a Country 2
    When Create a country name as "GokUlk13" code as "GokUlk13Kod"
    Then Success message should be displayed