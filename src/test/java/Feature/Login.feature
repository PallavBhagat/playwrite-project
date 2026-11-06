Feature: OrangeHRM Login Functionality

  Scenario: Verify user can login with valid credentials

    Given User opens the OrangeHRM website
    When User enters valid username and password
    And User clicks on the Login button
    Then User should be redirected to the Dashboard
    And User should see the Dashboard page