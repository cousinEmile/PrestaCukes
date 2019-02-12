Feature: Sort Test




  @sort
  Scenario Outline: Rank Sort Test <ranks>
    Given that user is at homepage
    Then verify that Medal Table is sorted by rank
    When user clicks NOC link
    Then table should be sorted by country names
    And Rank column is not in ascending order anymore


