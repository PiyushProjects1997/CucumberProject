@Smoke
Feature: Login Feature
Scenario Outline: Test to verify that successfully login with multiple user
Given User is on login page
When User enters valid username and valid password
	|username	|	password	|
	|Piyushgolu9199@gmail.com	| Piyush@1997|
	
Then User should able to logged in successfully.