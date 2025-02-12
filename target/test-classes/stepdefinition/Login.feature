@Login
Feature: Login Feature 

Background: 
Given User is on Login Page

Scenario: Successful login in with valid credential
When user enter valid credential
Then User should redirected to Home page




