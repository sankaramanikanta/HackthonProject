Feature: Extract Popular Used Car Models in Chennai

  Scenario: Extract Popular Used Car Models
    Given User moves mouse to usedcars section
    When user click the chennai as city
    Then redirected to usedcars page and scroll down to popular models
    And user retrieve the list of popular Usedcars models in chennai
