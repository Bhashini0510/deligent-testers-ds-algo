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
Feature: Feature for DataStructures Validation
  I want to use this template for my feature file

 

  Scenario: User enters Data Structure Page
    Given User logged in homepage for DataStructure
    When  User select Get started for DataStructure 
    Then  User should be directed to DataStructure page
    And   "Data Structures" is displayed on DataStructure page
    And   User checks for Topics covered in DataStructure page

 

  Scenario Outline: TryEditor verification in each page for valid code
   
   
    Given User logged in homepage for DataStructure 
    When User select Get started for DataStructure 
    Then  User should be directed to DataStructure page
    When  User clicks for options "<options>" in DataStructure page
    Then  User lands in Topics "<Topics>" in DataStructure Page
    And   Checks for links available in DataStructure page
    When  User clicks on Try Here button in DataStructure page
    Then  User navigates to a page having TryEditor and Run Button in DataStructure
    When  User gets valid input from "<sheetname>" and <Row> to run a tryEditor code in DataStructure
    Then  User is presented with run output in DataStructure
 
    
  Examples:
  |options         | Topics                                |sheetname | Row |
  |Time Complexity | Time Complexity                       | inputs   | 1   |
  

   Scenario Outline: TryEditor verification in each page for invalid code
      
    Given User logged in homepage for DataStructure 
    When User select Get started for DataStructure 
    Then  User should be directed to DataStructure page
    When  User clicks for options "<options>" in DataStructure page
    Then  User lands in Topics "<Topics>" in DataStructure Page
    And   Checks for links available in DataStructure page
    When  User clicks on Try Here button in DataStructure page
    Then  User navigates to a page having TryEditor and Run Button in DataStructure
    When  User gets invalid input from "<sheet>" and <Rownumber> to run a tryEditor code in DataStructure
    Then  User gets error message in DataStructure
    
  Examples:
   |options         | Topics                                | sheet   | Rownumber |
   |Time Complexity | Time Complexity                       | inputs  | 2         |
  


  Scenario Outline: TryEditor in each links for valid code
    Given User logged in homepage for DataStructure 
    When User select Get started for DataStructure 
    Then  User should be directed to DataStructure page
    When  User clicks for options "<options>" in DataStructure page
    And   User clicks on link "<link>" in the DataStructure page
    When  User clicks on Try Here button in DataStructure page
    Then  User navigates to a page having TryEditor and Run Button in DataStructure
    When  User gets valid input from "<sheetname>" and <Row> to run a tryEditor code in DataStructure
    Then  User is presented with run output in DataStructure
   
   Examples:
   |options         | link                                  |sheetname | Row |
   |Time Complexity | Time Complexity                       | inputs   | 1   |
 

   Scenario Outline: TryEditor in each links for invalid code
   Given User logged in homepage for DataStructure 
    When User select Get started for DataStructure 
    Then  User should be directed to DataStructure page
    When  User clicks for options "<options>" in DataStructure page
    And   User clicks on link "<link>" in the DataStructure page
    When  User clicks on Try Here button in DataStructure page
    Then  User navigates to a page having TryEditor and Run Button in DataStructure
    When  User gets invalid input from "<sheet>" and <Rownumber> to run a tryEditor code in DataStructure
    Then  User gets error message in DataStructure
   
  Examples:
   |options         | link            |sheet     | Rownumber |
   |Time Complexity | Time Complexity | inputs   | 2         |
 

   Scenario Outline: Practice questions validation
    Given User logged in homepage for DataStructure 
    When User select Get started for DataStructure 
    Then  User should be directed to DataStructure page
   When  User clicks for options "<options>" in DataStructure page
   And   clicks on Practice questions in DataStructure page
   Then  User navigates to Practice questions Page in DataStructure
    
    Examples: 
    | options        |
    |Time Complexity |