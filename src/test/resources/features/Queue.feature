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
Feature: Feature for Queue Validation
  I want to use this template for my feature file

 

  Scenario: User enters Queue Page
    Given User logged in homepage for Queue
    When  User select Queue from dropdown
    Then  User should be directed to Queue page
    And   "Queue" is displayed on Queue page
    And   User checks for Topics covered in Queue page

 

  Scenario Outline: TryEditor verification in each page for valid code
   
   
    Given User logged in homepage for Queue 
    When  User select Queue from dropdown
    Then  User should be directed to Queue page
    When  User clicks for options "<options>" in Queue page
    Then  User lands in Topics "<Topics>" in Queue Page
    And   Checks for links available in Queue page
    When  User clicks on Try Here button in Queue page
    Then  User navigates to a page having TryEditor and Run Button in Queue
    When  User gets valid input from "<sheetname>" and <Row> to run a tryEditor code in Queue
    Then  User is presented with run output in Queue
 
    
  Examples:
  |options                               | Topics                                |sheetname | Row |
  |Implementation of Queue in Python     | Implementation of Queue in Python     | inputs   | 1   |
  |Implementation using collections.deque| Implementation using collections.deque| inputs   | 1   |
  |Implementation using array            | Implementation using array            | inputs   | 1   |
  |Queue Operations                      | Queue Operations                      | inputs   | 1   |

   Scenario Outline: TryEditor verification in each page for invalid code
      
    Given User logged in homepage for Queue 
    When  User select Queue from dropdown
    Then  User should be directed to Queue page
    When  User clicks for options "<options>" in Queue page
    Then  User lands in Topics "<Topics>" in Queue Page
    And   Checks for links available in Queue page
    When  User clicks on Try Here button in Queue page
    Then  User navigates to a page having TryEditor and Run Button in Queue
    When  User gets invalid input from "<sheet>" and <Rownumber> to run a tryEditor code in Queue
    Then  User gets error message in Queue
    
  Examples:
  |options                               | Topics                                |sheet  | Rownumber|
  |Implementation of Queue in Python     | Implementation of Queue in Python     |inputs | 2        |
  |Implementation using collections.deque| Implementation using collections.deque|inputs | 2        |
  |Implementation using array            | Implementation using array            |inputs | 2        |
  |Queue Operations                      | Queue Operations                      |inputs | 2        |
  

  Scenario Outline: TryEditor in each links for valid code
    Given User logged in homepage for Queue
    When  User select Queue from dropdown
    Then  User should be directed to Queue page
    When  User clicks for options "<options>" in Queue page
    And   User clicks on link "<link>" in the Queue page
    When  User clicks on Try Here button in Queue page
    Then  User navigates to a page having TryEditor and Run Button in Queue
    When  User gets valid input from "<sheetname>" and <Row> to run a tryEditor code in Queue
    Then  User is presented with run output in Queue
   
   Examples:
   |options                                | link                                  | sheetname | Row |
   |Implementation of Queue in Python      | Implementation using collections.deque| inputs    | 1   |
   |Implementation using collections.deque | Implementation of Queue in Python     | inputs    | 1   |
   |Implementation using array             | Queue Operations                      | inputs    | 1   |
   |Queue Operations                       | Implementation using array            | inputs    | 1   | 
 

   Scenario Outline: TryEditor in each links for invalid code
    Given User logged in homepage for Queue
    When  User select Queue from dropdown
    Then  User should be directed to Queue page
    When  User clicks for options "<options>" in Queue page
    And   User clicks on link "<link>" in the Queue page
    When  User clicks on Try Here button in Queue page
    Then  User navigates to a page having TryEditor and Run Button in Queue
    When  User gets invalid input from "<sheet>" and <Rownumber> to run a tryEditor code in Queue
    Then  User gets error message in Queue
   
   Examples:
   |options                                | link                                   | sheet   | Rownumber|
   |Implementation of Queue in Python      | Queue Operations                       |inputs   | 2        |
   |Implementation using collections.deque | Implementation using array             |inputs   | 2        |
   |Implementation using array             | Implementation of Queue in Python      |inputs   | 2        |
   |Queue Operations                       | Implementation using collections.deque |inputs   | 2        |
 
  

   Scenario Outline: Practice questions validation
   Given User logged in homepage for Queue
   When  User select Queue from dropdown
   Then  User should be directed to Queue page
   When  User clicks for options "<options>" in Queue page
   And   clicks on Practice questions in Queue page
   Then  User navigates to Practice questions Page in Queue
    
    Examples: 
    | options                                                  |
    | Implementation of Queue in Python                        |
    | Implementation using collections.deque                   |
    | Implementation using array                               |
    | Queue Operations                                         |