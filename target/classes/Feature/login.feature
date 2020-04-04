Feature: Academic page login feature
Scenario Outline: when user is want register
Given user is academic page
When user clicks on registration link
Then user enters "<email>" and "<password>" and "<cnfpassword>"
Examples:
		|email|password|cnfpassword|
		|msreedharreddy447@gmail.com|Sreedhar@447|Sreedhar@447|
	
Scenario: Academic page login test Scenario
Given user is already on Academic page
When title of academic page is Journals  Oxford Academic  or not
Then user verify the oxford img logo is present or not
Then user clicks on registerpage 
Then user verifies  whethere the signin link present
Then user eneter into the home page by enterring login credentials and user enters into loginpage
Then user close the bowser



Scenario: when  user is on home page then perfom operations
Given user is on home page

When user verifies homepage title
Then user checks label
Then user verifies the logo 
Then user is able to click on Arts&humanities link
Then user is able to click on Medicines&health link
Then user is able to click on Access and purchase link
Then user close the browser



