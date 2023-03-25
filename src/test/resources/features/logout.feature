@AZUL10-340
Feature: US-002 Log out Function

  Background:
    Given The user is on the login page
    And The user logs in as a "Marketing"

  @AZUL10-370
  Scenario: AC-1 The user can log out and ends up on the login page
    When The user clicks on logout button
    Then The user ends up on the "Authorization" page

  @AZUL10-371
  Scenario: AC-2 The user can not go to the home page again by clicking the step back button after successfully logging out
    When The user clicks on logout button
    And The user ends up on the "Authorization" page

    When clicks on go back arrow in browser
    Then The user ends up on the "Authorization" page

  @AZUL10-372
  Scenario: AC-3 The user must be logged out if the user close the open tab (all tabs if there are multiple open tabs)
    When The user closes all the open tabs
    And The user is on the login page
    Then The user ends up on the "Authorization" page
