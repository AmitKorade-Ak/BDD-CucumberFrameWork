@test
Feature: Login
  Scenario Outline:Validate that user able to login Application
    Given User launch Chrome browser
    When user open URL <url>
    Then User Validate Total count of Cards 6
    Then close browser
    Examples:
      | url                 |
      | https://demoqa.com/ |