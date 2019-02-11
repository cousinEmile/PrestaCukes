$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/login_myAddresses.feature");
formatter.feature({
  "name": "Login - My Addresses",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "that user is on the homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "Login_MyAccountStepDefinitions.that_user_is_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user selects the sign-in link",
  "keyword": "When "
});
formatter.match({
  "location": "Login_MyAccountStepDefinitions.user_selects_the_sign_in_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enters valid credentials",
  "keyword": "And "
});
formatter.match({
  "location": "Login_MyAccountStepDefinitions.enters_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@myAddress"
    }
  ]
});
formatter.step({
  "name": "user selects My Addresses",
  "keyword": "Given "
});
formatter.match({
  "location": "Login_MyAddressesStepDefinitions.user_selects_My_Addresses()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user selects Add a new address",
  "keyword": "When "
});
formatter.match({
  "location": "Login_MyAddressesStepDefinitions.user_selects_Add_a_new_address()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "first and last name should match username on header",
  "keyword": "Then "
});
formatter.match({
  "location": "Login_MyPersonalInformationStepDefinitions.first_and_last_name_should_match_username_on_header()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user deletes the first name",
  "keyword": "When "
});
formatter.match({
  "location": "Login_MyAddressesStepDefinitions.user_deletes_the_first_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks save",
  "keyword": "And "
});
formatter.match({
  "location": "Login_MyAddressesStepDefinitions.clicks_save()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "error message should contain MYADDRESS_ERROR",
  "keyword": "Then "
});
formatter.match({
  "location": "Login_MyAddressesStepDefinitions.error_message_should_contain_MYADDRESS_ERROR()"
});
formatter.result({
  "status": "passed"
});
});