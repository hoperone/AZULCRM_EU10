@AZUL10-362
Feature: Login Function

  Background:
    Given The user is on the login page

  @AZUL10-359
  Scenario Outline: HR user can login with valid credentials

    When I enter valid HR username "<username>"
    And I enter valid HR password "<password>"
    And I click the login button
    Then I should be redirected to the HR dashboard

    Examples:
      | username               | password |
      | hr13@cybertekschool.com | UserUser |
      | hr24@cybertekschool.com | UserUser |
      | hr34@cybertekschool.com | UserUser |
      | hr44@cybertekschool.com | UserUser |
      | hr55@cybertekschool.com | UserUser |
      | hr65@cybertekschool.com | UserUser |
      | hr74@cybertekschool.com | UserUser |
      | hr82@cybertekschool.com | UserUser |

  @AZUL10-360
  Scenario Outline: Marketing user can login with valid credentials

    When I enter valid Marketing username "<username>"
    And I enter valid Marketing password "<password>"
    And I click the login button
    Then I should be redirected to the Marketing dashboard

    Examples:
      | username                      | password |
      | marketing1@cybertekschool.com | UserUser |
      | marketing2@cybertekschool.com | UserUser |
      | marketing3@cybertekschool.com | UserUser |
      | marketing4@cybertekschool.com | UserUser |
      | marketing5@cybertekschool.com | UserUser |
      | marketing6@cybertekschool.com | UserUser |
      | marketing7@cybertekschool.com | UserUser |
      | marketing8@cybertekschool.com | UserUser |

  @AZUL10-361
  Scenario Outline: Helpdesk user can login with valid credentials

    When I enter valid Helpdesk username "<username>"
    And I enter valid Helpdesk password "<password>"
    And I click the login button
    Then I should be redirected to the Helpdesk dashboard

    Examples:
      | username                     | password |
      | helpdesk31@cybertekschool.com | UserUser |
      | helpdesk32@cybertekschool.com | UserUser |
      | helpdesk33@cybertekschool.com | UserUser |
      | helpdesk34@cybertekschool.com | UserUser |
      | helpdesk35@cybertekschool.com | UserUser |
      | helpdesk36@cybertekschool.com | UserUser |
      | helpdesk37@cybertekschool.com | UserUser |
      | helpdesk38@cybertekschool.com | UserUser |

  @AZUL10-363
  Scenario: User can see "Remember me on this computer" link exists and is clickable on the login page
    Then I should see a "Remember me on this computer" link
    And the link should be clickable

  @AZUL10-364
  Scenario: User land on the 'Get Password' page after clicking on the "Forgot your password?" link
    When user clicks on "Forgot your password?" link
    Then user lands on the 'Get Password' page

  @AZUL10-365
  Scenario: User should see the password in bullet signs by default
    When user enters a random password
    Then user sees the password in bullet signs

  @AZUL10-366
  Scenario Outline: All users can see their own usernames in the profile menu, after successful login
    When I enter valid username "<username>"
    And I enter valid password "<password>"
    And I click the login button
    When I should be redirected to the Helpdesk dashboard
    Then users can see their own usernames "<username>" in the profile menu

    Examples:
      | username                     | password |
      | helpdesk31@cybertekschool.com | UserUser |
      | helpdesk32@cybertekschool.com | UserUser |
      | helpdesk33@cybertekschool.com | UserUser |
      | helpdesk36@cybertekschool.com | UserUser |
      | helpdesk37@cybertekschool.com | UserUser |
      | helpdesk38@cybertekschool.com | UserUser |
      | hr36@cybertekschool.com       | UserUser |
      | hr37@cybertekschool.com       | UserUser |
      | hr38@cybertekschool.com       | UserUser |

  @AZUL10-367
  Scenario Outline: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page
    When I enter valid username "<username>"
    And I enter valid password "<password>"
    And hit enter key on keyboard
    Then I should be redirected to the Helpdesk dashboard

    Examples:
      | username                     | password |
      | helpdesk38@cybertekschool.com | UserUser |

  @AZUL10-368
  Scenario Outline: "Please fill out this field" message should be displayed if the password or username is empty
    When I enter valid username "<username>"
    And I click the login button
    Then "Please fill out this field" message should be displayed

    Examples:
      | username                     | password |
      | helpdesk38@cybertekschool.com | UserUser |

  @AZUL10-369
  Scenario Outline: "Incorrect login or password." should be displayed for invalid credentials
    When I enter valid username "<username>"
    And I enter invalid password "<password>"
    And I click the login button
    Then "Incorrect login or password" should be displayed

    Examples:
      | username                     | password   |
      | helpdesk38@cybertekschool.com | XXUserUser |
