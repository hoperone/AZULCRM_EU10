@AZUL10-362
Feature: Login Function

  Background:
    Given The user is on the login page

  @AZUL10-359
  Scenario Outline: TC01-1 HR user can login with valid credentials

    When The user enters username "<username>"
    And The user enters password "<password>"
    And The user clicks on the login button
    Then The user should be redirected the Portal Page

    Examples:
      | username                | password |
      | hr13@cybertekschool.com | UserUser |
      | hr24@cybertekschool.com | UserUser |
      | hr34@cybertekschool.com | UserUser |
      | hr55@cybertekschool.com | UserUser |
      | hr65@cybertekschool.com | UserUser |
      | hr74@cybertekschool.com | UserUser |
      | hr82@cybertekschool.com | UserUser |

  @AZUL10-360
  Scenario Outline: TC01-2 Marketing user can login with valid credentials

    When The user enters username "<username>"
    And The user enters password "<password>"
    And The user clicks on the login button
    Then The user should be redirected the Portal Page

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
  Scenario Outline: TC01-3 Helpdesk user can login with valid credentials

    When The user enters username "<username>"
    And The user enters password "<password>"
    And The user clicks on the login button
    Then The user should be redirected the Portal Page

    Examples:
      | username                      | password |
      | helpdesk31@cybertekschool.com | UserUser |
      | helpdesk32@cybertekschool.com | UserUser |
      | helpdesk33@cybertekschool.com | UserUser |
      | helpdesk34@cybertekschool.com | UserUser |
      | helpdesk35@cybertekschool.com | UserUser |
      | helpdesk36@cybertekschool.com | UserUser |
      | helpdesk37@cybertekschool.com | UserUser |
      | helpdesk38@cybertekschool.com | UserUser |

  @AZUL10-363
  Scenario: TC05 User can see "Remember me on this computer" link exists and is clickable on the login page

    Given The user sees "Remember me on this computer" link
    Then the link is clickable

  @AZUL10-364
  Scenario: User land on the 'Get Password' page after clicking on the "Forgot your password?" link
    When user clicks on "Forgot your password?" link
    Then user lands on the 'Get Password' page

  @AZUL10-365
  Scenario: User should see the password in bullet signs by default
    When The user enters a valid password
    Then user sees the password in bullet signs

  Scenario Outline: AC-8
    When The user logs in as a "<userType>"
    And The user should be redirected the Portal Page
    Then users can see their own usernames "<username>" in the profile menu
    Examples:
      | userType  |
      | HR        |
      | Marketing |
      | Helpdesk  |

  @AZUL10-366
  Scenario Outline: AC-8 All users can see their own usernames in the profile menu, after successful login
    When I enter valid username "<username>"
    And I enter valid password "<password>"
    And The user clicks on the login button
    When I should be redirected to the Helpdesk dashboard
    Then users can see their own usernames "<username>" in the profile menu

    Examples:
      | userType  |
      | HR        |
      | Marketing |
      | Helpdesk  |

  @AZUL10-367
  Scenario: TC07 Verify if the ‘Enter’ key of the keyboard is working correctly on the login page
    When The user enters a valid username
    And The user enters a valid password
    And hit enter key on keyboard
    Then The user should be redirected the Portal Page

  @AZUL10-368
  Scenario: TC03-01 "Please fill out this field" message should be displayed if the username is empty
    When The user enters a valid username
    And The user clicks on the login button
    Then "Please fill out this field" message should be displayed

  @AZUL10-418
  Scenario: TC03-02 "Please fill out this field" message should be displayed if the password is empty
    When The user enters a valid password
    And The user clicks on the login button
    Then "Please fill out this field" message should be displayed

  @AZUL10-369
  Scenario: TC02-1 "Incorrect login or password." should be displayed for invalid credentials
    When The user enters a valid username
    And The user enters invalid password
    And The user clicks on the login button
    Then "Incorrect login or password" message should be displayed

  @AZUL10-419
  Scenario: TC02-2 "Incorrect login or password." should be displayed for invalid credentials
    When The user enters invalid username
    And The user enters a valid password
    And The user clicks on the login button
    Then "Incorrect login or password" message should be displayed

