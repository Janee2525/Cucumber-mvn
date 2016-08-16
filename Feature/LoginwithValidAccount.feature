

Feature: User login successfully with valid account

Scenario: User login with a valid account
Given User is on Catalog homepage
And click on log yourself in link
When enter valid username and password
And click sign in button
Then "Welcome, to iBusiness" message is displayed


