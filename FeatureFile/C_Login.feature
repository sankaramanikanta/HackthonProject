Feature: Google Login Error Handling

  Scenario: Invalid Google Account Login
    Given User click on login/register button
    When User select Google for login
    And Enter the wrong email and click next
    Then User capture the error message
