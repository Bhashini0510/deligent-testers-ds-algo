
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
Feature: Graph feature validation

Scenario: user is able to navigate to graph datastructure
Given user is on home page in graph
When user click graph from dropdown to select graph
Then user should be navigate to graph page

@tag1
Scenario Outline: Try editor in graph with valid code

Given user is on home page in graph
When  User select graph from dropdown
Then  User should navigated to graph page
When user clicks "<options>" in graph
Then user navigates is in "<title>" in graph page
When  user clicks on Try Here button in graph
Then  User should be in editor page in graph
When  User gets valid inputs from "<sheet>" and <Row> in graph
Then  User is presented with run outputs in graph

Examples:

  |    options              | title                   | sheet          |Row|      
  |Graph                    | Graph                   | inputs         | 0 |      
  |Graph Representations    | Graph Representations   | inputs         | 0 |      

Scenario Outline: Try editor in graph with invalid code

Given user is on home page in graph
When  User selects graph from dropdown
Then  User should be navigated to graph page
When user click "<options>" in graph
Then user navigate is in "<title>" in graph page
When  user click on Try Here button in graph
Then  User should move to editor page in graph
When  User get invalid inputs from "<sheet>" and <Row> in graph
Then  User is present with alert box and message in graph

Examples:

  |    options              | title                   | sheet          |Row|      
  |Graph                    | Graph                   | inputs         | 1 |      
  |Graph Representations    | Graph Representations   | inputs         | 1 |     

  Scenario Outline: TryEditor in each links with valid code
    Given user is on homepage in graph
    When  User select graph option from dropdown in graph
    Then  User should be directed to graph page
      When user click "<options>" in the graph
    And   User click on "<link>" in page in graph
    When  User click a Try Here button in graph
    Then  User navigates to page having Editor in graph
    When  user get correct input from "<sheet>" and <Row> in graph
    Then  User get output in graph
 Examples:
  |    options              | link                    | sheet          |Row|      
  |Graph                    | Graph                   | inputs         | 0 |      
  |Graph                    | Graph Representations   | inputs         | 0 |     
  |Graph Representations    | Graph                   | inputs         | 0 |  
  |Graph Representations    | Graph Representations   | inputs         | 0|  


     Scenario Outline: TryEditor in each links with invalid code
    Given user is on homepage in graph
    When  User selects graph option from dropdown
    Then  user should be direct to graph page
    When  User click for "<options>" in graph
    And   User click on "<link>" in this page
    When  user clicks the Try Here button in graph
    Then  User navigates to page having Editor in graph
    When  user gets incorrect input from "<sheet>" and <Row> in graph
    Then  user get alert in graph 
   Examples:
  |    options              | link                    | sheet          |Row|      
  |Graph                    | Graph                   | inputs         | 1 |      
  |Graph                    | Graph Representations   | inputs         | 1 |     
  |Graph Representations    | Graph                   | inputs         | 1 |  
  |Graph Representations    | Graph Representations   | inputs         | 1 |  

Scenario Outline:practice question validation
    Given user is on homepage in graph
    When  User choose graph option from dropdown
    Then  user should be in graph page
    When  User choose for "<options>" in graph
    And user click practice question in graph
    Then user directed to practice question url in graph
    Examples:
    |options|
    |Graph|
    |Graph Representations|
