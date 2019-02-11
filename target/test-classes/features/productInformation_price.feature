Feature: Product Information - Price

  @price
  Scenario:
    Given user is on homepage
    When user selects an item
    Then product information should be displayed
    And product info should match homepage info
