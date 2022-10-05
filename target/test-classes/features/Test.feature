Feature: Challenge | Automation | UI Only



Scenario: Login existent user.
   Given I am on the home page of saucedemo
   When I enter UserName: "standard_user"
   And I enter PassWord: "secret_sauce"
   Then I click Login
   And I enter in the Homepage correctly

Scenario: Login locked out user.
  Given I am on the HomePage of saucedemo
  When I enter the UserName: "locked_out_user"
  And I enter the PassWord: "secret_sauce"
  Then I click button Login
  And A pop up should appear with this string: "Epic sadface: Sorry, this user has been locked out."

Scenario: Login non existent user.
  Given I am on the principal HomePage of saucedemo
  When I put in the field UserName: "non_existent"
  And I put in the field PassWord: "secret_sauce"
  Then I click on the Login button
  And A PopUp should appear with this string: "Epic sadface: Username and password do not match any user in this service."

Scenario: Login performance glitch user.
  Given I am on the main home page of saucedemo
  When I enter in the field UserName: "performance_glitch_user"
  And I enter in the field PassWord: "secret_sauce"
  Then I click in the Login button and the page must load in 2 seconds
  And I enter in the Homepage rightly

Scenario: Login problem user.
  Given I am on the principal home page of saucedemo
  When I put UserName: "problem_user"
  And I put PassWord: "secret_sauce"
  Then I click Login button
  And I enter in the Homepage properly
  And I validate that it is a functional page at first sight and have no repeated elements