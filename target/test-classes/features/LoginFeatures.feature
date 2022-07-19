@TRA-320
Feature: Login Functionality feature
  User Story: As a user, I should be able to login.

  Background:
    Given The user is on the login page


#Acceptance Criteria - 1
@TRA-309
  Scenario: Login as a driver
    When The user logs in as a driver
    Then The user is on the Quick Launchpad page

@TRA-310
  Scenario: Login as a sales manager
    When The user logs in as a sales manager
    Then The user is on the Dashboard page
@TRA-311
  Scenario: Login as a store manager
    When The user logs in as a store manager
    Then The user is on the Dashboard page


#Acceptance Criteria - 2
@TRA-312
  Scenario: Login without providing credentials
    When user copy the url after login and log out, paste the same url to browser
    Then The system shouldn't allow users to access the application


#Acceptance Criteria - 3
@TRA-313
  Scenario: Warning messages
  When The user logs in with invalid credentials
  Then Please fill out this field message should be displayed for any empty field

@scenario4
#4- Users should see their password in bullet signs while typing
  Scenario Outline: User should see their password in bullet signs while typing
    When The user logs in with "<userName>"
    And user types on the passwordInputBox with "<password>"
    Then The user should see their bullet sign
    Examples:
      | userName        | password    |
      | user1           | UserUser123 |
      | salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |




#Acceptance Criteria - 5
@TRA-314
  Scenario: Forgot Password menu
  When The user click Forgot your password link on login page
  Then The user land on the Forgot Password page


#Acceptance Criteria - 6
@TRA-315
  Scenario: Logging in with Remember me on this computer
  When Remember me on this computer checkbox is clicked after valid credentials is provided
  And The user logs in next time
  Then The user log in without providing credentials


#Acceptance Criteria - 7
@TRA-316
  Scenario: Switching next field with Enter key
  When The user clicks on Username input box and hits Enter button
  Then The cursor appears on Password input box, hit Enter again, Login button gets clicked


#Acceptance Criteria - 8
@TRA-317
  Scenario: The driver can see username in profile menu
  When The user logs in as a driver
  Then The driver can see the username in the profile menu

@TRA-318
  Scenario: The Sales Manager can see the username in profile menu
  When The user logs in as a sales manager
  Then The sales manager can see the username in the profile menu

@TRA-319
  Scenario: The Store Manager can see the username in the profile menu
  When The user logs in as a store manager
  Then The store manager can see the username in the profile menu









