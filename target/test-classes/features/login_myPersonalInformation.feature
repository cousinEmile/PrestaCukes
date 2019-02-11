Feature: Login - My Personal Information

  Background:
    Given that user is on the homepage
    When user selects the sign-in link
    And enters valid credentials

@personalInfo
  Scenario:
    Given that user selects My Personal Information
    Then title should match MYPERSONALINFO_TITLE
    And first and last name should match username on header
    When user selects save
    Then error message shold match IDENTITY_ERROR
    When user selects Back to your Account
    Then the title should match MYACCOUNT_TITLE