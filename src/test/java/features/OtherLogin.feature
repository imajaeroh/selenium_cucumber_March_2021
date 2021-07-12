@OtherLogin @Regression
Feature: Techfios bank and cash New Account functionality


Background:
 Given User is on the login page


Scenario Outline: 1 User should be able to login with valid credentials 

	When User enters the "<username>" and "<password>"
	And User clicks on login button
	Then User should be able to see the dashboard
	When User clicks on bank and cash 
	When User clicks on new account 
	When User fill up the form entering "<accountTitle>" and  "<description>" and "<initialBalance>"  and "<accountNumber>" and "<contactPersons>" and "<phone>" and "<internetBanking>"
	And  User clicks on submit button
	Then User should be able to validate new account
	
		
	Examples:	
 |username          |password|accountTitle       |description   |initialBalance|accountNumber|contactPersons |phone       |internetBanking|
 |demo@techfios.com |abc123	 |checking Account   | New Account  |25000.00	   |3002567801	 |Pena Bechley	 |5172006636  |www.biatechlas.com|

#Scenario Outline:3 User should validate new account
#	And  User clicks on submit button
#	Then User should be able to see validate


	