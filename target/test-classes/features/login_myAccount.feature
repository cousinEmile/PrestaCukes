Feature: Login - My Account

  @myAccount
  Scenario:
    Given that user is on the homepage
    When user selects the sign-in link
    And enters valid credentials
    Then the title should match MYACCOUNT_TITLE
    And username should be displayed next to sign out link

