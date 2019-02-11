Feature: Product Information - Details

  Background:
    Given user is on homepage
    When user selects an item
    Then product information should be displayed
    And product info should match homepage info


@detail
  Scenario:

    Given that user has selected a product
    Then the quantity and size should be DEFAULT
    And the available sizes should match the SIZE_OPTIONS


