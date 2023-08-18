@linkedList
Feature: Linked List Page
  I want to use this template for my feature file

  @pageLaunch
  Scenario: User is able to navigate to Linked List using dropdown option
    Given User login to DSPortalapp using valid credentials
    When User click on Linked List from the dropdown
    Then LinkedList page is displayed
    And heaader Linked List is displayed
    
  @pageLaunch
  Scenario: User is able to navigate to Linked List using Get Strated option
    Given User login to DSPortalapp using valid credentials
    When User click on Get Started button for Linked List
    Then LinkedList page is displayed
    And heaader Linked List is displayed

  @pageValidation
  Scenario Outline: User is seeing topics in Linked list page
    Given User login to DSPortalapp using valid credentials
    When User click on Linked List from the dropdown
    Then Verify topics covered is displayed with "<topic>" links
    
    Examples:
    |topic|
    |Introduction,Creating Linked LIst,Types of Linked List,Implement Linked List in Python,Traversal,Insertion,Deletion|
    
  @pageValidation
  Scenario Outline: User is seeing topics in Linked list page
    Given User is on Linked List page with valid login
    When User selects "<topic>" in Linked_List page
    Then Verify topics covered is displayed with links on the left
    
    Examples:
    |topic|
    |Introduction,Creating Linked LIst,Types of Linked List,Implement Linked List in Python,Traversal,Insertion,Deletion|
    

    
  @pythoncodeValidation
  Scenario Outline: User is able to try code in Linked list page
    Given User is on Linked List page and click on the link from the excel sheet "LinkedList" and "<row>"
    When User clicks on try here button and enters code from the excel sheet "<row>" in the try editor page and clicks on Run
    Then The code is executed and the output from the excel "<row>" is displayed on the page
    
    Examples:
    |row|
    |0|
    |1|
    |2|
    |3|
    |4|
    |5|
    |6|
    |7|
    |8|
    |9|
    |10|
    |11|
    |12|
    |13|
    
    
    
  

