#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Feature for Stack Validation
  I want to use this template for my feature file

 

  Scenario: User enters Stack Page
    Given User logged in homepage
    When  User select stack from dropdown
    Then  User should be directed to Stack page
    And   "Stack" is displayed on page
    And   User checks for Topics covered in Stack page

 

  Scenario Outline: TryEditor verification in each page for valid code
   
   
    Given User logged in homepage 
    When  User select stack from dropdown
    Then  User should be directed to Stack page
    When  User clicks for options "<options>" in stack
    Then  User lands in Topics "<Topics>" in Stack Page
    And   Checks for links available in page
    When  User clicks on Try Here button
    Then  User navigates to a page having TryEditor and Run Button
    When  User gets valid input from "<sheetname>" and <Row> to run a tryEditor code
    Then  User is presented with run output
      
  Examples:
  |options            | Topics              |sheetname | Row |
  |Operations in Stack| Operations in Stack | inputs   | 1   |
  |Implementation     | Implementation      | inputs   | 1   |
  |Applications       | Applications        | inputs   | 1   |
 

Scenario Outline: TryEditor verification in each page for invalid code
     
    Given User logged in homepage 
    When  User select stack from dropdown
    Then  User should be directed to Stack page
    When  User clicks for options "<options>" in stack
    Then  User lands in Topics "<Topics>" in Stack Page
    And   Checks for links available in page
    When  User clicks on Try Here button
    Then  User navigates to a page having TryEditor and Run Button
    When  User gets invalid input from "<sheet>" and <Rownumber> to run a tryEditor code
    Then  User gets error message
  Examples:
  |options            | Topics              |sheet  | Rownumber|
  |Operations in Stack| Operations in Stack |inputs | 2        |
  |Implementation     | Implementation      |inputs | 2        |
  |Applications       | Applications        |inputs | 2        |
  
    
  Scenario Outline: TryEditor in each links for valid code
    Given User logged in homepage 
    When  User select stack from dropdown
    Then  User should be directed to Stack page
    When  User clicks for options "<options>" in stack
    And   User clicks on link "<link>" in the page
    When  User clicks on Try Here button
    Then  User navigates to a page having TryEditor and Run Button
    When  User gets valid input from "<sheetname>" and <Row> to run a tryEditor code
    Then  User is presented with run output
      
   Examples:
   |options            | link                | sheetname | Row |
   |Operations in Stack| Implementation      | inputs    | 1   |
   |Implementation     | Operations in Stack | inputs    | 1   |
   |Applications       | Implementation      | inputs    | 1   |
  
    
   Scenario Outline: TryEditor in each links for invalid code
    Given User logged in homepage 
    When  User select stack from dropdown
    Then  User should be directed to Stack page
    When  User clicks for options "<options>" in stack
    And   User clicks on link "<link>" in the page
    When  User clicks on Try Here button
    Then  User navigates to a page having TryEditor and Run Button
    When  User gets invalid input from "<sheet>" and <Rownumber> to run a tryEditor code
    Then  User gets error message 
   
    Examples:
   |options            | link                |sheet  | Rownumber|
   |Operations in Stack| Applications        |inputs | 2        |
   |Implementation     | Applications        |inputs | 2        |
   |Applications       | Operations in Stack |inputs | 2        |
 
   
   Scenario Outline: Practice questions validation
   Given  User logged in homepage 
   When   User select stack from dropdown
   Then  User should be directed to Stack page
   When  User clicks for options "<options>" in stack
   And   clicks on Practice questions
   Then  User navigates to Practice questions Page
    
    Examples: 
    | options             |
    | Operations in Stack |
    | Implementation      |
    | Applications        |