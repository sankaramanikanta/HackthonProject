Feature: Printing Upcoming Honda Bikes

  Scenario: View Upcoming Honda Bikes
    Given the user is on the zigwheels.com page
    When the user moves mouse on to the newbikes
    And click the upcomingbikes
    And user open the manufacturer dropdown
    And user select the honda in manufacturer
    Then user scrolldown and click view all filters
    And user print the details of upcoming honda bikes below 4 lakh
    And user navigates to the homepages
