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
Feature: Array verification

  Scenario: User enters arrays Page
    Given User logged in homepage in arrays
    When  User select arrays from dropdown in arrays
    Then  User should navigated to arrays page

 Scenario Outline: TryEditor link with valid code  in each page 
   
   
    Given User logged in homepage in arrays
    When  User select array from dropdown in arrays
    Then  User should navigated to arrays page
    When  User clicks for "<options>" link in arrays
    Then  User is in "<title>" in arrays Page 
    When  User clicks on Try Here button in arrays
    Then  User navigate to editor page in arrays
    When  User gets valid input from "<sheet>" and <Row> in arrays
    Then  User is presented with run output in arrays
    
  Examples:
  |    options              | title                   | sheet          |Row|      
  |Arrays in Python         | Arrays in Python        | inputs         | 0 |      
  |Arrays Using List        | Arrays Using List       | inputs         | 0 |      
  |Basic Operations in Lists|Basic Operations in Lists| inputs         | 0 |      
  |Applications of Array    |Applications of Array    | inputs         | 0 |   
     

 Scenario Outline: TryEditor link with valid code  in each page 
  Given User logged in homepage in arrays
    When  User selects array from dropdown in arrays
    Then  User should navigated to arrays page
    When  User click for "<options>" link in arrays
    Then  User is in "<title>"  arrays Page
    When  User clicks Try Here button in arrays
    Then  User navigates to editor page in arrays
    When  User gets invalid input "<sheetnumber>" and <Rowno> in arrays
    Then  User gets error message as alert in arrays
      Examples:
  |    options              | title                   | sheetnumber    |Rowno|      
  |Arrays in Python         | Arrays in Python        | inputs         | 1 |      
  |Arrays Using List        | Arrays Using List       | inputs         | 1 |      
  |Basic Operations in Lists|Basic Operations in Lists| inputs         | 1 |      
  |Applications of Array    |Applications of Array    | inputs         | 1 |      
  
 
Scenario Outline: TryEditor in each links with valid code
    Given User logged in homepage in arrays
    When  User select array option from dropdown in arrays
    Then  User should be directed to arrays page
    When  User clicks for "<options>" in arrays
    And   User clicks on "<link>" in the page in arrays
    When  User click on Try Here button in arrays
    Then  User navigates to a page having TryEditor in arrays
    When  User gets correct input from "<sheet>" and <Row> in arrays
    Then  User gets output in arrays
  
   
   Examples:
   |options                   | link                        |  sheet    |Row| 
   |Arrays in Python          | Arrays in Python            | inputs    |0 |
   |Arrays in Python          | Arrays Using List           | inputs    |0 |
   |Arrays in Python          | Basic Operations in Lists   | inputs    |0 |
   |Arrays in Python          | Applications of Array       | inputs    |0 |
   |Arrays Using List         | Arrays in Python            | inputs    |0 |
   |Arrays Using List         | Arrays Using List           | inputs    |0 |
   |Arrays Using List         | Basic Operations in Lists   | inputs    |0 | 
   |Arrays Using List         | Applications of Array       | inputs    |0 | 
   |Basic Operations in Lists | Arrays in Python            | inputs    |0 |
   |Basic Operations in Lists | Arrays Using List           | inputs    |0 |
   |Basic Operations in Lists | Basic Operations in Lists   | inputs    |0 |
   |Basic Operations in Lists | Applications of Array       | inputs    |0 | 
   | Applications of Array    | Arrays in Python            | inputs    |0 | 
   | Applications of Array    | Arrays Using List           | inputs    | 0| 
   | Applications of Array    | Basic Operations in Lists   | inputs    | 0| 
   | Applications of Array    | Applications of Array       | inputs    | 0| 
   
   Scenario Outline: TryEditor in each links with invalid code
    Given User logged in homepage in arrays
    When  User selects array option from dropdown in arrays
    Then  User should be directed to arrays page
    When  User clicks for "<options>" array 
    And   User click on "<link>" in the page in arrays
    When  User click Try Here button in arrays
    Then  User navigate to a page having TryEditor in arrays
    When  User gets invalid input from "<sheet>" and <Row> in arrays
    Then  User gets alert text in arrays
     
   Examples:
   |options                   | link                        |  sheet   |Row| 
   |Arrays in Python          | Arrays in Python            | inputs    |1 |
   |Arrays in Python          | Arrays Using List           | inputs    |1 |
   |Arrays in Python          | Basic Operations in Lists   | inputs    |1 |
   |Arrays in Python          | Applications of Array       | inputs    |1 |
   |Arrays Using List         | Arrays in Python            | inputs    |1 |
   |Arrays Using List         | Arrays Using List           | inputs    |1 |
   |Arrays Using List         | Basic Operations in Lists   | inputs    |1 | 
   |Arrays Using List         | Applications of Array       | inputs    |1 | 
   |Basic Operations in Lists | Arrays in Python            | inputs    |1 |
   |Basic Operations in Lists | Arrays Using List           | inputs    |1 |
   |Basic Operations in Lists | Basic Operations in Lists   | inputs    |1 |
   |Basic Operations in Lists | Applications of Array       | inputs    |1 | 
   | Applications of Array    | Arrays in Python            | inputs    |1 | 
   | Applications of Array    | Arrays Using List           | inputs    | 1| 
   | Applications of Array    | Basic Operations in Lists   | inputs    | 1| 
   | Applications of Array    | Applications of Array       | inputs    | 1| 
   
  @tag1
Scenario Outline: practice link verification
   Given  User logged in homepage in arrays
   When   User select arrays optn from dropdown in arrays
   Then  User should be directed to array page
   When  User clicks for "<options>" in array
   And   User clicks Practice questions in arrays
   Then  User navigates to Practice questions Page in arrays
   When user select "<link>" from list in arrays
   Then user should be directed to question page in arrays
   When user gets input from "<sheet>" and <Row> in arrays
   Then user gets output for above input in arrays
  
   Examples:
   
    |options                   | link                                  |  sheet    |Row| 
   |Arrays in Python          | Search the array                       | inputs    |2 |
   |Arrays in Python          | Max Consecutive Ones                   | inputs    |2 |
   |Arrays in Python          | Find Numbers with Even Number of Digits| inputs    |2 |
   |Arrays in Python          | Squares of  a Sorted Array            | inputs    |2 |
   |Arrays Using List         | Search the array                       | inputs    |2 | 
   |Arrays Using List         | Max Consecutive Ones                   | inputs    |2 |
   |Arrays Using List         | Find Numbers with Even Number of Digits| inputs    |2 | 
   |Arrays Using List         | Squares of  a Sorted Array            | inputs    |2 | 
   |Basic Operations in Lists | Search the array                       | inputs    |2|
   |Basic Operations in Lists | Max Consecutive Ones                   | inputs    |2 |
   |Basic Operations in Lists | Find Numbers with Even Number of Digits| inputs    |2 |
   |Basic Operations in Lists | Squares of  a Sorted Array            | inputs    |2 |
   | Applications of Array    | Search the array                       | inputs    |2 | 
   | Applications of Array    | Max Consecutive Ones                   | inputs    | 2|
   | Applications of Array    | Find Numbers with Even Number of Digits | inputs    | 2| 
   | Applications of Array    | Squares of  a Sorted Array             | inputs    | 2|
   @tag2
   Scenario Outline: practice link verification
   Given  User logged in homepage in arrays
   When   User select arrays options from dropdown in arrays
   Then  User should be navigated to array page
   When  User click for "<options>" in array
   And   User clicks on Practice questions in arrays
   Then  User navigate to Practice questions Page in arrays
   When user selects "<link>" from list in arrays
   Then user should directed to question page in arrays
   When user gets wrong input from "<sheet>" and <Row> in arrays
   Then user gets alert in arrays 
   When user clicks submit button in arrays
   Then user get error message in arrays
   Examples:
      
    |options                   | link                                  |  sheet    |Row| 
   |Arrays in Python          | Search the array                       | inputs    |1 |
   |Arrays in Python          | Max Consecutive Ones                   | inputs    |1 |
   |Arrays in Python          | Find Numbers with Even Number of Digits| inputs    |1 |
   |Arrays in Python          | Squares of  a Sorted Array             | inputs    |1 |
   |Arrays Using List         | Search the array                       | inputs    |1 | 
   |Arrays Using List         | Max Consecutive Ones                   | inputs    |1 |
   |Arrays Using List         | Find Numbers with Even Number of Digits| inputs    |1 | 
   |Arrays Using List         | Squares of  a Sorted Array          | inputs    |1 | 
   |Basic Operations in Lists | Search the array                       | inputs    |1|
   |Basic Operations in Lists | Max Consecutive Ones                   | inputs    |1 |
   |Basic Operations in Lists | Find Numbers with Even Number of Digits| inputs    |1|
   |Basic Operations in Lists | Squares of  a Sorted Array            | inputs    |1 |
   | Applications of Array    | Search the array                       | inputs    |1 | 
   | Applications of Array    | Max Consecutive Ones                   | inputs    | 1|
   | Applications of Array    | Find Numbers with Even Number of Digits | inputs    | 1| 
   | Applications of Array    | Squares of  a Sorted Array            | inputs    | 1|
   