Feature: Login to account
	Existing facebook user should be able to login to an account using correct credentials
	
Scenario Outline: Login to with correct credentials

Given user navigates to facebook website
And user clicks on the login button on homepage
When user enters a valid "<username>" and "<password>"
When the user clicks on the login button
Then the user should be taken to the successful login page
Given user clicks on logout button
Then user should be taken to the homepage

Examples:

	|username 		| password 	|
	|test1@gmail	 	| test1 	|
	|test2@gmail	 	| test2 	|
	