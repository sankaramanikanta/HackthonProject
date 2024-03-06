Feature: Smoke Test Suite

  @Smoke
  Scenario: Verifying Zig wheels Homepage
    Given user navigate to the Zigwheels homepage
    Then user should see a well-rendered homepage without any errors

  @Smoke
  Scenario: Verify Login Functionality
    Given is on the Zigwheels login page
    Then checks whether login/signup is present in the zigwheels tab

  @Smoke
  Scenario: Navigating to the login/register tab
    Given user is on the Zigwheels homepage
    When user click the login/signup button in homepage
    Then user should be directed to the login/register tab

  @Smoke
  Scenario: Verifying the header section of zigwheels
    Given user is on the Zigwheels homepage
    Then check whether New Bikes is present in the header section

  @Smoke
  Scenario: Verifying the New Bikes dropdown
    Given user is on the Zigwheels homepage
    When user hovers the mouse over the New Bikes
    Then check whether upcoming bikes is present in the New Bikes dropdown

  @Smoke
  Scenario: Navigating to the Used cars page
    Given user is on any page of the Zigwheels website
    When user clicks on the used cars
    Then user should navigate to used cars page
