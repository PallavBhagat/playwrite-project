Feature: OrangeHRM PIM Functionality

  Background:
    Given User opens the OrangeHRM website
    When User enters valid username and password
    And User clicks on the Login button
    Then User should be redirected to the Dashboard

  Scenario: Verify user can add and search for a new employee successfully
    When User clicks on the PIM menu
    And User clicks on the Add button
    And User enters the employee first name
    And User enters the employee middle name
    And User enters the employee last name
    And User enters the employee ID
    And User clicks on the Create Login Details slider
    And User enters the employee username
    And User enters the employee password
    And User enters the employee confirm password
    And User clicks on the Save button
    Then User should see a success message of PIM page

    When User clicks on the Employee List
    And User enters the employee ID in the search field
    And User clicks on the Search button
    Then User should see the employee in the search results
    And User should verify the employee name and employee ID