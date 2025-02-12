@HomePage
Feature: Home Page Feature

Background: 
Given User is on Login Page

Scenario: Successfully logout from Home Page
Given User is on Home Page
When Dropdown is displaying after post click on Searchbtn
And User click on logout btn
Then User should navigated back to LoginPage