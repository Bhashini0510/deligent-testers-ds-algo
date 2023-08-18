@tree
Feature: Tree Page
  I want to use this template for my feature file

  @pageLaunch
  Scenario: User is able to navigate to Tree using dropdown option
    Given User login to DSPortalapp using valid credential
    When User click on Tree from the dropdown
    Then Tree page is displayed
    And heaader Tree is displayed
    
  @pageLaunch
  Scenario: User is able to navigate to Tree using Get Strated option
    Given User login to DSPortalapp using valid credential
    When User click on Get Started button for Tree
    Then Tree page is displayed
    And heaader Tree is displayed

  @pageValidation
  Scenario Outline: User is seeing topics in Tree page
    Given User login to DSPortalapp using valid credential
    When User click on Tree from the dropdown
    Then Verify Tree Page is displayed with "<link>" links
    
    Examples:
    |link|
  	|Overview of Trees,Terminologies,Types of Trees,Tree Traversals,Traversals-Illustration,Binary Trees,Types of Binary Trees,Implementation in Python,Binary Tree Traversals,Implementation of Binary Trees,Applications of Binary trees,Binary Search Trees,Implementation Of BST|
  	
  @pageValidation
  Scenario Outline: User is seeing topics in Tree page
    Given User is on Tree page with valid login
    When User selects "<link>" in Tree page
    Then Verify topics covered is displayed with links on the left of the page
    
    Examples:
    |link|
    |Overview of Trees,Terminologies,Types of Trees,Tree Traversals,Traversals-Illustration,Binary Trees,Types of Binary Trees,Implementation in Python,Binary Tree Traversals,Implementation of Binary Trees,Applications of Binary trees,Binary Search Trees,Implementation Of BST|
    
 	 @pythoncodeValidation
 	 Scenario Outline: User is able to try code in Tree page
    Given User is on Tree page and click on the link from the excel sheet "Tree" and "<row>"
    When User clicks on try here button from tree page and enters code from the excel sheet "<row>" in the try editor page and clicks on Run
    Then The code is executed and the output from the excel "<row>" is displayed on the tree page
    
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
    |14|
    |15|
    |16|
    |17|
    |18|
    |19|
    |20|
    |21|
    |22|
    |23|
    |24|
    |25|
    
    
    
  

