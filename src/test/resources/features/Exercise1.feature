Feature: Trainline retrieve times and prices
  As a trainline user
  I want to set the journey details: "Brighton to London"
  So that I can retrieve the times and prices related

  Scenario Outline: journey details
    Given I'm on www.thetrainline.com main page
    When I enter journey details <journeyDetails1>, <journeyDetails2>
    And I click the return radio button
    And I click the tomorrow option
    And I click the next day option
    And I click get times & tickets
    Then times and prices are displayed

    Examples:
      | journeyDetails1 | journeyDetails2 |
      | "Brighton"      | "London"        |