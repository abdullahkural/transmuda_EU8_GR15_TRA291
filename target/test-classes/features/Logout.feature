@TRA-340
Feature: Logout Functionality feature
  User Story: As a user I should be able to log out

  Background:
    Given The user is on the homepage

#Acceptance Criteria - 1
@TRA-336
Scenario: User can log out by using log out button
  When The user click logout button inside profile
  Then The user should end up in the login page

#Acceptance Criteria - 2
@TRA-337
Scenario: User can not go to home page by clicking the step back button
  When The user clicks the step back button
  Then The user should not go to home page again

#Acceptance Criteria - 3
@TRA-338
Scenario: User must logged out when closing tab
  When The user close the tab
  Then The user must be logged out

#Acceptance Criteria - 4
@TRA-339
Scenario: User must be logged out if the user is away from keyboard for 3 min
  When The user is away from keyboard at least for three min
  Then The user must be logged out


