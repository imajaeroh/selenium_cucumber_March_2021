Feature: Techfios bank and cash New Account functionality


Background:
 Given User is on the login page

Scenario Outline: User should be able to login with valid credentials and open a new account

	When User enters the "<username>" and "<password>"
	And User clicks on login button
	Then User should be able to see the dashboard

Examples:
|username          |password|
|demo@techfios.com |abc123|