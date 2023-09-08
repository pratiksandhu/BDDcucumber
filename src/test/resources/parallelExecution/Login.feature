@Regression
Feature: Crm login
  
  Scenario: login into crm account
    Given user is on home page
    When user clicks on LogIN
    When user enters username "Pratiksandhu6162@gmail.com" and password "Pratik@123" and clicks on login button
    Then user is signed in and verify title.
    
