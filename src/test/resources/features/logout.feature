@AZUL10-340
Feature: US-002 Log out Function

  @AZUL10-370
  Scenario: The user can log out and ends up on the login page
    Given The user is on the login page
    When I enter valid username and password
    And I click the login button
    Then I should be redirected to the HR dashboard

    When clicks on logout
    Then should be asked to re enter login credentials

  @AZUL10-371
  Scenario: The user can not go to the home page again by clicking the step back button after successfully logging out
    Given The user is on the login page
    When I enter valid username and password
    And I click the login button
    Then I should be redirected to the HR dashboard

    When clicks on logout
    And clicks on go back arrow in browser
    Then should be asked to re enter login credentials

  @AZUL10-372
  Scenario: The user must be logged out if the user close the open tab (all tabs if there are multiple open tabs)
    Given The user is on the login page
    Then should be asked to re enter login credentials


