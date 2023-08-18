@home
Feature: Home Page feature validation


  Scenario: Home Page URL
    Given The user lands on DS Algo Portal
    When User enters the home page using Get Started button
    Then User is on Home Page URL
  
    Scenario: Content in Home Page
    When User enters the home page using Get Started button
    Then Title of the page NumpyNinja is displayed 
    And Data Structures is selected default in dropdown
    And Register with Signin is available
    
    Scenario: Content in Home Page dropdown
    When User enters the home page using Get Started button
    And User opens the dropdown in homepage
    Then Options Data Structures, Arrays, Linked List, Stack, Queue, Tree and Graph are displayed 
   
 
    Scenario Outline: Drop down selection without login
    When User select an "<option>" in dropdown without login
    Then User gets warning message You are not logged in
    
    Examples:
    |option|
    |Arrays|
    |Linked List|
    |Stack|
    |Queue|
    |Tree|
    |Graph|

    Scenario Outline: Get started button clicked without login
    When User clicks on Get Started button in any "<topic>"
    Then User gets warning message You are not logged in
    Examples:
    |topic|
    |Data Structures-Introduction|
    |Array|
    |Linked List|
    |Stack|
    |Queue|
    |Tree|
    |Graph|
    
    Scenario: Register Page Navigation
    When User clicks Register
    Then User lands on Register Page
    
    Scenario: Sign in Page Navigation
    Given The user lands on DS Algo Portal
    When User clicks Sign in
    Then User lands on Login Page
  