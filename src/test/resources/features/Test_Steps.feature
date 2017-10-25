Feature: Trainline retrieve times and prices
  As a trainline user
  I want to set the journey details: "Brighton to London"
  So that I can retrieve the times and prices related

  Background:
    Given I'm on www.thetrainline.com main page

    ## Exercise 1 and 2, searching for journey details
  Scenario Outline: Exercise 1 and 2: search for journey details
    Given I enter journey details <journeyDetails1>, <journeyDetails2>
    And I click get times & tickets
    Then times and prices are displayed

    Examples:
      | journeyDetails1 | journeyDetails2 |
      | "Brighton"      | "London"        |

    ## Exercise 3, radio button and changing travel dates
  Scenario Outline: Exercise 3 click radio button and change travel dates
    Given I enter journey details <journeyDetails1>, <journeyDetails2>
    And I click the return radio button
    And I click the tomorrow option
    And I click the next day option
    When I click get times & tickets
    Then times and prices are displayed

  Examples:
  | journeyDetails1 | journeyDetails2 |
  | "Brighton"      | "London"        |

    ## Exercise 5, using the calender widget
#  @wip
  Scenario Outline: Exercise 5
    Given I enter journey details <journeyDetails1>, <journeyDetails2>
    And I click the return radio button
    And I select the outward journey to be "10" days in the future
    When I click get times & tickets
    Then times and prices are displayed

  Examples:
  | journeyDetails1 | journeyDetails2 |
  | "Brighton"      | "London"        |



    ###Extension

  Scenario Outline: Plan Journey - list times and prices for a single journey for 2 adults and 2 children
    Given I enter journey details <journeyDetails1>, <journeyDetails2>
    And I select the passenger summary dropdown
    And I select 2 adults
    And I select 2 children
    When I click get times & tickets
    Then times and prices are displayed

  Examples:
  | journeyDetails1 | journeyDetails2 |
  | "Brighton"      | "London"        |

#  @wip
  Scenario Outline: Plan journey - list times and prices for a return trip on the same day
    Given I enter journey details <journeyDetails1>, <journeyDetails2>
    And I click the return radio button
    And I select a return date for the same day
    When I click get times & tickets
    Then times and prices are displayed

    Examples:
      | journeyDetails1 | journeyDetails2 |
      | "Brighton"      | "London"        |

  Scenario: Plan journey - find the cheapest route for a single journey from Aberdeen to York
#    TODO: Using the best fare finder, print out the times and price for the cheapest return from Aberdeen to York
#    TODO: Going out on the 11th Nov +/- 3 days, returning 25th Nov +/- days
#    Given I enter journey details <journeyDetails1>, <journeyDetails2>
    ## look up how bestfarefinder actually works


  Scenario: Plan journey - user attempts to plan for a date in the past
    #TODO: User attempts to plan a journey which occurs in the past - error message should be displayed
#    Given I enter journey details <journeyDetails1>, <journeyDetails2>
    And I select a date in the past
    When I click get times & tickets
    Then An error message is displayed

  Scenario Outline: Plan journey - find the closest station
    Given I am on the station finder
    And I have provided the Post Code <postCode>
    Then the closest station should be <station>

    Examples:
      | postCode | station          |
      | BN12 4SE | Durrington-On-Sea|
      | BN3 7EP  | Aldrington       |