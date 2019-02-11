Feature: Product Information - Add to Cart


  Background:
    Given user is on homepage
    When user selects an item

@addToCart
  Scenario:
    Given that user adds current item to cart
    Then confirmation message should match ADDTOCART_MSG
    And quantity and size should be