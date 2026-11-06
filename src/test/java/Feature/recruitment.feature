Feature: OrangeHRM Recruitment Functionality

  Background:
    Given User opens the OrangeHRM website
    When User enters valid username and password
    And User clicks on the Login button
    Then User should be redirected to the Dashboard

  Scenario: Verify user can add a new candidate successfully
    When User clicks on the Recruitment menu
    And User clicks on the Add button
    And User enters the candidate first name
    And User enters the candidate middle name
    And User enters the candidate last name
    And User selects the vacancy
    And User enters the candidate email address
    And User enters the candidate contact number
    And User uploads the candidate resume
    And User enters the candidate keywords
    And User enters the candidate notes
    And User selects the consent checkbox
    And User clicks on the Save button
    Then User should see a success message of recruitment page

    When User clicks on the Recruitment menu
    And User selects the Vacancy from the dropdown
    And User clicks on the Search button
    Then User should see the newly added candidate in the search results
    And User should verify the candidate name and vacancy in Recruitment