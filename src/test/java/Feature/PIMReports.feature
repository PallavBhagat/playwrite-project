Feature: OrangeHRM PIM Reports Functionality

  Background:
    Given User opens the OrangeHRM website
    When User enters valid username and password
    And User clicks on the Login button
    Then User should be redirected to the Dashboard

  Scenario: Verify user can add and search a PIM report successfully
    When User clicks on the PIM menu
    And User clicks on the Reports menu
    And User clicks on the Add button
    And User enters the report name
    And User fills the report details
    And User clicks on the Save button
    When User clicks on the Reports menu
    And User enters the report name in the search field
    And User clicks on the Search button
    Then User should see the report name in the search results
    And User should verify the report name