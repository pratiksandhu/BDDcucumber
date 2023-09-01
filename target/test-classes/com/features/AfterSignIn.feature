Feature: test afterSignInPage

  Background: 
    Given user is already logged in
      | username                   | password   |
      | pratiksandhu6162@gmail.com | Pratik@123 |

  Scenario: test contacts page
    Given user is on AfterSignInPage
    When user clicks on contacts
    Then contacts page is opened
 
  Scenario: test deals page
    Given user is on AfterSignInPage
    When user clicks on deals
    Then deals page is opened
