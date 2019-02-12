Feature: Registration Test

@registration
  Scenario:
    Given user is on homepage
    When user selects the sign-in link
    And selects Create Account
    Then email link should display current email
    When user fills out Account Information
    And selects Register
    #need header check
    When that user selects My Personal Information
    Then users personal information is displayed correctly
    When user selects Back to your Account
    And user selects My Addresses
    Then address information should be displayed correctly
    When user selects "<sign-out>" link
    And user logs back in with valid credentials
    Then current username should be displayed next to sign out link
