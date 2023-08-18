@login
Feature: Login feature validation

	@success
  Scenario: Register link validation from Sign in page
    Given User is in Sign in page
    When User clicks on Register link
    Then User navigates to Register page
    
  @failure  
  Scenario Outline: User enters invalid username 
    Given User is in Sign in page
    When User user enters invalid username <username> and password <password>
    Then Error message is displayed as Invalid username and Password
    
	 Examples:
	| username | password  |
	| par123   | Welcome1  |


  Scenario Outline: User enters invalid username from excel 
    Given User is in Sign in page
    When User user enters invalid username and password from  sheet "Login" and rownumber <row>
    Then Error message is displayed as Invalid username and Password
    
	 Examples:
	|row|
	| 0 |