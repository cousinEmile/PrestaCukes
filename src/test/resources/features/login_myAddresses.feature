Feature: Login - My Addresses

  Background:
    Given that user is on the homepage
    When user selects the sign-in link
    And enters valid credentials

@myAddress
    Scenario:
      Given user selects My Addresses
      When user selects Add a new address
      Then first and last name should match username on header
      When user deletes the first name
      And clicks save
      Then error message should contain MYADDRESS_ERROR

